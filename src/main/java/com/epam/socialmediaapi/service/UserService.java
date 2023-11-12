package com.epam.socialmediaapi.service;

import com.epam.socialmediaapi.model.User;

import java.util.List;

public interface UserService {
    User followUser(Long userId, Long followerId);
    User unfollowUser(Long userId, Long followerId);
    User createUser(User user);
    List<User> getAllUsers();

    User getUserById(Long userId);
}
