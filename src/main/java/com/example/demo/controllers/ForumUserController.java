package com.example.demo.controllers;

import com.example.demo.dtos.forumuser.ForumUserInputDTO;
import com.example.demo.dtos.forumuser.ForumUserOutputDTO;
import com.example.demo.services.ForumUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.file.AccessDeniedException;
import java.security.Principal;
import java.util.List;
import java.util.UUID;





@RestController
@RequestMapping("/forumusers")
@Api(description = "Actions related to forum users")
public class ForumUserController {

    @Autowired
    private ForumUserService forumUserService;

    @ApiOperation("Gets forumuser with id given")
    @GetMapping("/{id}")
    public ForumUserOutputDTO getForumUser(@Valid @PathVariable("id") UUID id) {
        return forumUserService.getForumUser(id);
    }

    @ApiOperation("Adds forumuser, needs user information in body")
    @PostMapping("/")
    public ForumUserOutputDTO addForumUser(@Valid @RequestBody ForumUserInputDTO forumUserInputDTO) {
        return forumUserService.addForumUser(forumUserInputDTO);
    }

    @ApiOperation("Deletes forumuser with id given")
    @DeleteMapping("/{id}")
    public void deleteForumUser(@Valid @PathVariable("id") UUID id, Principal principal) throws AccessDeniedException {
        forumUserService.deleteForumUser(id, principal);
    }

    @ApiOperation("Gets all users")
    @GetMapping("/allUsers")
    public List<ForumUserOutputDTO> getAllUsers() {
        return forumUserService.getForumUsers();
    }



}



