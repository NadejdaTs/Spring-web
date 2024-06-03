package com.likebookapp.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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

    @ManyToMany
    @JoinTable(name = "posts_users",
    joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<User> likes;

    @ManyToOne
    @NotNull
    private Mood mood;

    public Post(){
        this.likes = new ArrayList<>();
    }
}
