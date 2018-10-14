package com.example.demo.dtos.topic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TopicInputDTO extends ResourceSupport {
    @NotNull(message = "Topic title must not be null.")
    @Size(min = 2, message = "Topic title should have at least 2 characters")
    @Size(max = 100, message = "Topic title can't have more than 100 characters")
    private String title;

    @NotNull(message = "Text should not be null.")
    @Size(min = 1, message = "Text should have at least 1 characters")
    @Size(max = 10000, message = "Text can't have more than 10000 characters")
    private String text;
}