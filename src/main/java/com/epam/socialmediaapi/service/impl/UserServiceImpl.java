package com.epam.socialmediaapi.service.impl;

import com.epam.socialmediaapi.model.User;
import com.epam.socialmediaapi.repository.UserRepository;
import com.epam.socialmediaapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }


    @Override
    public User followUser(Long userId, Long followerId) {
        User userToFollow = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        User follower = userRepository.findById(followerId).orElseThrow(NoSuchElementException::new);

        userToFollow.getFollowers().add(follower);
        return userRepository.save(userToFollow);
    }

    @Override
    public User unfollowUser(Long userId, Long followerId) {
        User userToUnfollow = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        User follower = userRepository.findById(followerId).orElseThrow(NoSuchElementException::new);

        userToUnfollow.getFollowers().remove(follower);
        return userRepository.save(userToUnfollow);
    }

}

