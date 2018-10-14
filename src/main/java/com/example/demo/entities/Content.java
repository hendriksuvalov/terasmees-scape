package com.example.demo.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@Table(name = "content")
@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "text")
    @Size(min = 2, message = "Your content should have more than 2 characters.")
    @Size(max = 1000, message = "Your content should have less than 1000 characters.")
    private String text;

    @JoinColumn(name = "post", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    private Post post;
}