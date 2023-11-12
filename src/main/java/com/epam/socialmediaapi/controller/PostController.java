package com.epam.socialmediaapi.controller;

import com.epam.socialmediaapi.model.Post;
import com.epam.socialmediaapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postService.createPost(post);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    @PostMapping("/{postId}/like/{userId}")
    public ResponseEntity<Post> likePost(@PathVariable Long postId, @PathVariable Long userId) {
        Post updatedPost = postService.likePost(postId, userId);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    @PostMapping("/{postId}/unlike/{userId}")
    public ResponseEntity<Post> unlikePost(@PathVariable Long postId, @PathVariable Long userId) {
        Post updatedPost = postService.unlikePost(postId, userId);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getPostsByUser(@PathVariable Long userId) {
        List<Post> posts = postService.getPostsByUser(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/followed")
    public ResponseEntity<List<Post>> getPostsByUserAndFollowedUsers(@PathVariable Long userId) {
        List<Post> posts = postService.getPostsByUserAndFollowedUsers(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}

