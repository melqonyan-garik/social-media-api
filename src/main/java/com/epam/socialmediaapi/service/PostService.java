package com.epam.socialmediaapi.service;

import com.epam.socialmediaapi.model.Post;

import java.util.List;

// PostService.java
public interface PostService {
    Post createPost(Post post);
    List<Post> getAllPosts();
    Post likePost(Long postId, Long userId);
    Post unlikePost(Long postId, Long userId);
    List<Post> getPostsByUser(Long userId);
    List<Post> getPostsByUserAndFollowedUsers(Long userId);
}
