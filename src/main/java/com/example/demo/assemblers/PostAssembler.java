package com.example.demo.assemblers;

import com.example.demo.controllers.PostController;
import com.example.demo.dtos.post.PostOutputDTO;
import com.example.demo.entities.Post;
import com.example.demo.repositories.ContentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PostAssembler extends ResourceAssemblerSupport<Post, PostOutputDTO> {

    @Autowired
    private ForumUserAssembler forumUserAssembler;

    @Autowired
    private TopicAssembler topicAssembler;

    @Autowired
    private ContentRepo contentRepo;

    public PostAssembler() {
        super(PostController.class, PostOutputDTO.class);
    }

    public PostOutputDTO toResource(Post post) {
        return PostOutputDTO.builder()
                .uuid(post.getId())
                .topic(topicAssembler.toResource(post.getTopic()))
                .text(contentRepo.findByPost(post).orElseThrow(() -> new EntityNotFoundException("This post doesn’t have content")).getText())
                .createdAt(post.getCreatedAt())
                .createdBy(forumUserAssembler.toResource(post.getCreatedBy()))
                .build();
    }
}
