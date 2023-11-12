package com.epam.socialmediaapi.controller;

import com.epam.socialmediaapi.model.Post;
import com.epam.socialmediaapi.service.PostService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostControllerTest {
    @Mock
    private PostService postService;

    @InjectMocks
    private PostController postController;

    @Test
    public void testGetPostsByUser() {
        // Arrange
        Long userId = 1L;
        List<Post> mockPosts = Arrays.asList(new Post(), new Post());
        when(postService.getPostsByUser(userId)).thenReturn(mockPosts);

        // Act
        ResponseEntity<List<Post>> response = postController.getPostsByUser(userId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockPosts, response.getBody());
    }
}
