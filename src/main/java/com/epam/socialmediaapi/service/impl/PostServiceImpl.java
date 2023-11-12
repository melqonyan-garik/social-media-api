package com.epam.socialmediaapi.service.impl;

import com.epam.socialmediaapi.model.Post;
import com.epam.socialmediaapi.model.User;
import com.epam.socialmediaapi.repository.PostRepository;
import com.epam.socialmediaapi.repository.UserRepository;
import com.epam.socialmediaapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;


    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    @Override
    public Post likePost(Long postId, Long userId) {
        Post post = postRepository.findById(postId).orElseThrow(NoSuchElementException::new);
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);

        post.getLikedBy().add(user);
        return postRepository.save(post);
    }

    @Override
    public Post unlikePost(Long postId, Long userId) {
        Post post = postRepository.findById(postId).orElseThrow(NoSuchElementException::new);
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);

        post.getLikedBy().remove(user);
        return postRepository.save(post);
    }
    @Override
    public List<Post> getPostsByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        return postRepository.findByAuthor(user);
    }

    @Override
    public List<Post> getPostsByUserAndFollowedUsers(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        Set<User> followedUsers = user.getFollowers();

        List<User> usersToInclude = new ArrayList<>(followedUsers);
        usersToInclude.add(user);

        return postRepository.findByAuthorIn(usersToInclude);
    }
}

