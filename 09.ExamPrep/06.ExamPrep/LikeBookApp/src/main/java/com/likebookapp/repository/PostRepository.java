package com.likebookapp.repository;

import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
    Optional<Post> findByContent(String content);

    List<Post> findByUser(User user);

    List<Post> findByUserNot(User user);
}
