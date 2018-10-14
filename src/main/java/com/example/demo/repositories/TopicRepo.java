package com.example.demo.repositories;

import com.example.demo.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TopicRepo extends JpaRepository<Topic, UUID> {
    Optional<Topic> findById(UUID id);
    List<Topic> findAll();
}
