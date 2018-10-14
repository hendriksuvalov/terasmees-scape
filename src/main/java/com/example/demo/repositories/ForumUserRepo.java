package com.example.demo.repositories;

import com.example.demo.entities.ForumUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ForumUserRepo extends JpaRepository<ForumUser, UUID> {
    Optional<ForumUser> findById(UUID id);
    List<ForumUser> findAll();
    ForumUser findByUsername(String username);
}
