package com.likebookapp.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post extends BaseEntity{
    @Column(nullable = false)
    private String content;

    @ManyToOne
    @NotNull
    private User user;

    @OneToMany(mappedBy = "username")
    private List<User> userLikes;

    @ManyToOne
    @NotNull
    private Mood mood;
}
