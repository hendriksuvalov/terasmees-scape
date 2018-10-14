package com.example.demo.services;

import com.example.demo.dtos.post.PostInputDTO;
import com.example.demo.entities.Content;
import com.example.demo.entities.ForumUser;
import com.example.demo.entities.Post;
import com.example.demo.repositories.ContentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContentService {

    @Autowired
    private ContentRepo contentRepo;

    @Transactional
    public void addContent(Post post, PostInputDTO postInputDTO, ForumUser forumUser) {
        Content content = new Content();
        content.setPost(post);
        content.setText(postInputDTO.getText());
        contentRepo.saveAndFlush(content);
    }
}
