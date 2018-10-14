package com.example.demo.controllers;

import com.example.demo.dtos.post.PostInputDTO;
import com.example.demo.dtos.topic.TopicInputDTO;
import com.example.demo.dtos.topic.TopicOutputDTO;
import com.example.demo.services.PostService;
import com.example.demo.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.file.AccessDeniedException;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public TopicOutputDTO getTopic(@Valid @PathVariable("id") UUID topicId) {
        return topicService.getTopic(topicId);
    }

    @GetMapping("/")
    public List<TopicOutputDTO> getAllTopics() {
        return topicService.getTopics();
    }

    @PostMapping("/")
    public void addTopic(@RequestBody TopicInputDTO topicInputDTO, Principal principal) {
        topicService.addTopic(topicInputDTO, principal);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@Valid @PathVariable("id") UUID topicId, Principal principal) throws AccessDeniedException {
        topicService.deleteTopic(topicId, principal);
    }

    @PostMapping("/{id}/post")
    public void addPost(@Valid @PathVariable("id") UUID topicId, @RequestBody PostInputDTO postInputDTO, Principal principal) {
        postService.addPost(topicId, postInputDTO, principal);
    }

    @DeleteMapping("/{id}/post/{postId}")
    public void deletePost(@Valid @PathVariable("postId") UUID postId, Principal principal) throws AccessDeniedException {
        postService.deletePost(postId, principal);
    }
}
