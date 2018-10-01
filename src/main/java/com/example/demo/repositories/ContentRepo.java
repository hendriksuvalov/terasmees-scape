package com.example.demo.repositories;

import com.example.demo.entities.Content;
import com.example.demo.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContentRepo extends JpaRepository<Content, UUID> {
    Optional<Content> findByPost(Post post);
}