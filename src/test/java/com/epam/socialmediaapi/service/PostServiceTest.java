package com.epam.socialmediaapi.service;

import com.epam.socialmediaapi.model.Post;
import com.epam.socialmediaapi.repository.PostRepository;
import com.epam.socialmediaapi.service.impl.PostServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PostServiceTest {
    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostServiceImpl postService;

    @Test
    public void testGetPostsByUser() {
        // Arrange
        Long userId = 1L;
        List<Post> mockPosts = Arrays.asList(new Post(), new Post());
        when(postRepository.findByAuthor(any())).thenReturn(mockPosts);

        // Act
        List<Post> result = postService.getPostsByUser(userId);

        // Assert
        assertEquals(mockPosts, result);
    }
}
