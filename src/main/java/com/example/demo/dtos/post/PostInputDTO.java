package com.example.demo.dtos.post;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PostInputDTO extends ResourceSupport {
    @NotNull(message = "Text should not be null.")
    @Size(min = 1, message = "Text should have at least 1 characters")
    @Size(max = 10000, message = "Text can't have more than 10000 characters")
    private String text;
}