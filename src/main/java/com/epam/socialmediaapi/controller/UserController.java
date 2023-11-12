package com.epam.socialmediaapi.controller;

import com.epam.socialmediaapi.model.User;
import com.epam.socialmediaapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/{userId}/follow/{followerId}")
    public ResponseEntity<User> followUser(@PathVariable Long userId, @PathVariable Long followerId) {
        User updatedUser = userService.followUser(userId, followerId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{followerId}")
    public ResponseEntity<User> unfollowUser(@PathVariable Long userId, @PathVariable Long followerId) {
        User updatedUser = userService.unfollowUser(userId, followerId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<User> getUserById(Long userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }
}


