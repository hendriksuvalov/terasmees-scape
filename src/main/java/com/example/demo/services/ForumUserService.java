package com.example.demo.services;

import com.example.demo.assemblers.ForumUserAssembler;
import com.example.demo.dtos.forumuser.ForumUserInputDTO;
import com.example.demo.dtos.forumuser.ForumUserOutputDTO;
import com.example.demo.entities.ForumUser;
import com.example.demo.entities.enums.UserRole;
import com.example.demo.repositories.ForumUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.nio.file.AccessDeniedException;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Service
public class ForumUserService {

    @Autowired
    private ForumUserRepo forumUserRepo;

    @Autowired
    private ForumUserAssembler forumUserAssembler;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public ForumUserOutputDTO getForumUser(UUID id) {
        ForumUser forumUser = forumUserRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("This user doesn't exist."));
        return forumUserAssembler.toResource(forumUser);
    }

    public ForumUserOutputDTO addForumUser(ForumUserInputDTO forumUserInputDTO) {
        ForumUser forumUser = new ForumUser();
        forumUser.setEmail(forumUserInputDTO.getEmail());
        forumUser.setUsername(forumUserInputDTO.getUsername());
        forumUser.setPassword(bCryptPasswordEncoder.encode(forumUserInputDTO.getPassword()));
        forumUser.setRole(UserRole.USER);
        forumUser = forumUserRepo.saveAndFlush(forumUser);
        return forumUserAssembler.toResource(forumUser);
    }

    public List<ForumUserOutputDTO> getForumUsers() {
        return forumUserAssembler.toResources(forumUserRepo.findAll());
    }

    public void deleteForumUser(UUID userId, Principal principal) throws AccessDeniedException {
        ForumUser forumUser = forumUserRepo.findById(userId).orElseThrow(() -> new EntityNotFoundException("This user does not exist."));
        if (!forumUser.getUsername().equals(principal.getName())) {
            throw new AccessDeniedException("You can delete only your own profile.");
        }
        forumUserRepo.delete(forumUser);
    }
}
