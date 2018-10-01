package com.example.demo.assemblers;

import com.example.demo.controllers.ForumUserController;
import com.example.demo.dtos.forumuser.ForumUserOutputDTO;
import com.example.demo.entities.ForumUser;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

@Service
public class ForumUserAssembler extends ResourceAssemblerSupport<ForumUser, ForumUserOutputDTO> {

    public ForumUserAssembler() {
        super(ForumUserController.class, ForumUserOutputDTO.class);
    }

    public ForumUserOutputDTO toResource(ForumUser forumUser) {
        return ForumUserOutputDTO.builder()
                .uuid(forumUser.getId())
                .username(forumUser.getUsername())
                .build();
    }
}