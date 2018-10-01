package com.example.demo.dtos.topic;

import com.example.demo.dtos.forumuser.ForumUserOutputDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TopicOutputDTO extends ResourceSupport {
    private UUID uuid;
    private String title;
    private LocalDateTime createdAt;
    private ForumUserOutputDTO createdBy;
}
