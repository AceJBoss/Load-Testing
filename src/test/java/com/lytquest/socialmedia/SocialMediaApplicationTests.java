package com.lytquest.socialmedia;

import com.lytquest.socialmedia.entity.Post;
import com.lytquest.socialmedia.repository.PostRepository;
import com.lytquest.socialmedia.service.impl.PostServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class SocialMediaApplicationTests {

    @Autowired
    private PostServiceImpl postService;

    @MockBean
    private PostRepository postRepository;

    @DisplayName("Test fetchUsers()")
    @Test
    public void getPost(){
      when(postRepository.findAll()).thenReturn(Stream.of(new Post(100L, "Title 1", "Content 1", new Date()),
              new Post(200L, "Title 2", "Content 2", new Date())).collect(Collectors.toList()));
      assertEquals(2, postService.getPosts().size());
    }


}
