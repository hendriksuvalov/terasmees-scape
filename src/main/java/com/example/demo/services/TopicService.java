package com.example.demo.services;

import com.example.demo.assemblers.TopicAssembler;
import com.example.demo.dtos.post.PostInputDTO;
import com.example.demo.dtos.topic.TopicInputDTO;
import com.example.demo.dtos.topic.TopicOutputDTO;
import com.example.demo.entities.ForumUser;
import com.example.demo.entities.Post;
import com.example.demo.entities.Topic;
import com.example.demo.repositories.ForumUserRepo;
import com.example.demo.repositories.PostRepo;
import com.example.demo.repositories.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.nio.file.AccessDeniedException;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Service
public class TopicService {

    @Autowired
    private TopicRepo topicRepo;

    @Autowired
    private TopicAssembler topicAssembler;

    @Autowired
    private ForumUserRepo forumUserRepo;

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private PostService postService;

    @Transactional
    public void addTopic(TopicInputDTO topicInputDTO, Principal principal) {
        Topic topic = new Topic();
        topic.setTitle(topicInputDTO.getTitle());
        topic.setCreatedBy(forumUserRepo.findByUsername(principal.getName()));
        topic = topicRepo.saveAndFlush(topic);

        PostInputDTO postInputDTO = new PostInputDTO();
        postInputDTO.setText(topicInputDTO.getText());
        postService.addPost(topic.getId(), postInputDTO, principal);
    }

    public List<TopicOutputDTO> getTopics() {
        return topicAssembler.toResources(topicRepo.findAll());
    }

    public TopicOutputDTO getTopic(UUID topicId) {
        return topicAssembler.toResource(topicRepo.findById(topicId).orElseThrow(() -> new EntityNotFoundException("This topic does not exist.")));
    }

    public void deleteTopic(UUID topicId, Principal principal) throws AccessDeniedException {
        ForumUser forumUser = forumUserRepo.findByUsername(principal.getName());
        Topic topic = topicRepo.findById(topicId).orElseThrow(() -> new EntityNotFoundException("This topic does not exist."));
        if (forumUser != topic.getCreatedBy()) {
            throw new AccessDeniedException("You can only delete topics you created.");
        }
        List<Post> topicPosts = postRepo.findAllByTopic(topic);
        for (Post p : topicPosts) {
            postRepo.delete(p);
        }
        topicRepo.delete(topic);
    }
}
