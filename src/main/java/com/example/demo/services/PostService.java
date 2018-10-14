package com.example.demo.services;

import com.example.demo.assemblers.PostAssembler;
import com.example.demo.dtos.post.PostInputDTO;
import com.example.demo.dtos.post.PostOutputDTO;
import com.example.demo.entities.ForumUser;
import com.example.demo.entities.Post;
import com.example.demo.entities.Topic;
import com.example.demo.repositories.ForumUserRepo;
import com.example.demo.repositories.PostRepo;
import com.example.demo.repositories.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.nio.file.AccessDeniedException;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private PostAssembler postAssembler;

    @Autowired
    private TopicRepo topicRepo;

    @Autowired
    private ForumUserRepo forumUserRepo;

    @Autowired
    private ContentService contentService;

    public void addPost(UUID topicId, PostInputDTO postInputDTO, Principal principal) {
        ForumUser forumUser = forumUserRepo.findByUsername(principal.getName());
        Topic topic = topicRepo.findById(topicId).orElseThrow(() -> new EntityNotFoundException("This topic does not exist."));
        Post post = new Post();
        post.setCreatedBy(forumUser);
        post.setTopic(topic);
        post = postRepo.saveAndFlush(post);

        contentService.addContent(post, postInputDTO, forumUser);
    }

    public void deletePost(UUID postId, Principal principal) throws AccessDeniedException {
        ForumUser forumUser = forumUserRepo.findByUsername(principal.getName());
        Post post = postRepo.findById(postId).orElseThrow(() -> new EntityNotFoundException("This post does not exist."));
        if (forumUser != post.getCreatedBy()) {
            throw new AccessDeniedException("You can only delete posts that you created");
        }
        postRepo.delete(post);
    }

    public List<PostOutputDTO> getPosts(UUID topicId) {
        Topic topic = topicRepo.findById(topicId).orElseThrow(() -> new EntityNotFoundException("This topic does not exist."));
        return postAssembler.toResources(postRepo.findAllByTopic(topic));
    }
}
