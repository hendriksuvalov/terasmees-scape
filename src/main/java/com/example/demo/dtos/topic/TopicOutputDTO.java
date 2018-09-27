package com.example.demo.dtos.topic;

import com.example.demo.dtos.forumuser.ForumUserOutputDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TopicOutputDTO {
    private UUID id;
    private String title;
    private ForumUserOutputDTO createdBy;
    private LocalDateTime createdAt;
}
