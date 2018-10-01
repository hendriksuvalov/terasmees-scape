package com.example.demo.assemblers;

import com.example.demo.controllers.TopicController;
import com.example.demo.dtos.topic.TopicOutputDTO;
import com.example.demo.entities.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

@Service
public class TopicAssembler extends ResourceAssemblerSupport<Topic, TopicOutputDTO> {

    @Autowired
    ForumUserAssembler forumUserAssembler;


    public TopicAssembler() {
        super(TopicController.class, TopicOutputDTO.class);
    }

    public TopicOutputDTO toResource(Topic topic) {
        return TopicOutputDTO.builder()
                .uuid(topic.getId())
                .title(topic.getTitle())
                .createdAt(topic.getCreatedAt())
                .createdBy(forumUserAssembler.toResource(topic.getCreatedBy()))
                .build();
    }

}
