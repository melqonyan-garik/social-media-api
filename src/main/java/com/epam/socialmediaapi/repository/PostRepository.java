package com.epam.socialmediaapi.repository;

import com.epam.socialmediaapi.model.Post;
import com.epam.socialmediaapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByAuthor(User author);
    List<Post> getPostsByUser(Long userId);
    List<Post> getPostsByUserAndFollowedUsers(Long userId);


    List<Post> findByAuthorIn(List<User> usersToInclude);
}
