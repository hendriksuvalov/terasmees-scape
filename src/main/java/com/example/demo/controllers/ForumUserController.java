package com.example.demo.controllers;

import com.example.demo.dtos.forumuser.ForumUserInputDTO;
import com.example.demo.dtos.forumuser.ForumUserOutputDTO;
import com.example.demo.services.ForumUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.file.AccessDeniedException;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/forumusers")
public class ForumUserController {

    @Autowired
    private ForumUserService forumUserService;

    @GetMapping("/{id}")
    public ForumUserOutputDTO getForumUser(@Valid @PathVariable("id") UUID id) {
        return forumUserService.getForumUser(id);
    }

    @PostMapping("/")
    public ForumUserOutputDTO addForumUser(@Valid @RequestBody ForumUserInputDTO forumUserInputDTO) {
        return forumUserService.addForumUser(forumUserInputDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteForumUser(@Valid @PathVariable("id") UUID id, Principal principal) throws AccessDeniedException {
        forumUserService.deleteForumUser(id, principal);
    }

    @GetMapping("/allUsers")
    public List<ForumUserOutputDTO> getAllUsers() {
        return forumUserService.getForumUsers();
    }
}
