package com.example.demo.dtos.forumuser;

import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ForumUserInputDTO extends ResourceSupport {
    @NotNull(message = "Username must not be null.")
    @Size(min = 2, message = "Username should have at least 2 characters")
    @Size(max = 70, message = "Username can't have more than 70 characters")
    private String username;

    @NotNull
    @Size(min = 4, message = "Email should have at least 4 characters")
    @Size(max = 255, message = "Email can't have more than 255 characters")
    private String email;

    @NotNull(message = "Password must not be null.")
    @Size(min = 6, message = "Password should have at least 6 characters")
    @Size(max = 28, message = "Password can't have more than 28 characters")
    private String password;
}