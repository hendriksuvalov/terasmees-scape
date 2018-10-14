package com.example.demo.repositories;

import com.example.demo.entities.Post;
import com.example.demo.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostRepo extends JpaRepository<Post, UUID> {
    List<Post> findAllByTopic(Topic topic);
    Optional<Post> findById(UUID id);
}
