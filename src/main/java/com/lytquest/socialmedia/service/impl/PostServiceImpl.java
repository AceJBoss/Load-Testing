package com.lytquest.socialmedia.service.impl;

import com.lytquest.socialmedia.entity.Post;
import com.lytquest.socialmedia.repository.PostRepository;
import com.lytquest.socialmedia.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Post post, Long id) {
        Post existingPost = postRepository.findById(id).orElse(null);
        existingPost.setTitle(post.getTitle());
        existingPost.setContent(post.getContent());
        existingPost.setPostDate(post.getPostDate());
        return existingPost;
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post fetchAPost(Long id) {
      Post post = postRepository.findById(id).orElse(null);
      return post;
    }

    @Override
    public String deletePost(Long id) {
        postRepository.deleteById(id);
        return "Post Deleted Successfully";
    }
}
