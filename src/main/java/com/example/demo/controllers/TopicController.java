package com.example.demo.controllers;

import com.example.demo.dtos.post.PostInputDTO;
import com.example.demo.dtos.topic.TopicInputDTO;
import com.example.demo.dtos.topic.TopicOutputDTO;
import com.example.demo.services.PostService;
import com.example.demo.services.TopicService;
import com.wordnik.swagger.annotations.ApiOperation;
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

    @ApiOperation("Gets topic with id given")
    @GetMapping("/{id}")
    public TopicOutputDTO getTopic(@Valid @PathVariable("id") UUID topicId) {
        return topicService.getTopic(topicId);
    }

    @ApiOperation("Gets all topics")
    @GetMapping("/")
    public List<TopicOutputDTO> getAllTopics() {
        return topicService.getTopics();
    }

    @ApiOperation("Adds new topic, needs topic title and message in body")
    @PostMapping("/")
    public void addTopic(@RequestBody TopicInputDTO topicInputDTO, Principal principal) {
        topicService.addTopic(topicInputDTO, principal);
    }

    @ApiOperation("Deletes topic with id given")
    @DeleteMapping("/{id}")
    public void deleteTopic(@Valid @PathVariable("id") UUID topicId, Principal principal) throws AccessDeniedException {
        topicService.deleteTopic(topicId, principal);
    }

    @ApiOperation("Adds new post to a topic with id given, needs message in body")
    @PostMapping("/{id}/post")
    public void addPost(@Valid @PathVariable("id") UUID topicId, @RequestBody PostInputDTO postInputDTO, Principal principal) {
        postService.addPost(topicId, postInputDTO, principal);
    }

    @ApiOperation("Deletes post in topic (id given) with post id given")
    @DeleteMapping("/{id}/post/{postId}")
    public void deletePost(@Valid @PathVariable("postId") UUID postId, Principal principal) throws AccessDeniedException {
        postService.deletePost(postId, principal);
    }
}
