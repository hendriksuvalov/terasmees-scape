package com.example.demo.dtos.content;

import com.example.demo.dtos.post.PostOutputDTO;
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
public class ContentOutputDTO extends ResourceSupport {

    private UUID uuid;
    private PostOutputDTO post;
    private String text;
    private LocalDateTime createdAt;
}