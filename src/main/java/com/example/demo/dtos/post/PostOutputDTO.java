package com.example.demo.dtos.post;

import com.example.demo.dtos.forumuser.ForumUserOutputDTO;
import com.example.demo.dtos.topic.TopicOutputDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PostOutputDTO extends ResourceSupport {

    private UUID uuid;
    private TopicOutputDTO topic;
    private String text;
    private LocalDateTime createdAt;
    private ForumUserOutputDTO createdBy;
}
