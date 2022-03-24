package com.lytquest.socialmedia.service;

import com.lytquest.socialmedia.entity.Post;

import java.util.List;

public interface PostService {
    public Post createPost(Post post);
    public Post updatePost(Post post, Long id);
    public List<Post> getPosts();
    public Post fetchAPost(Long id);
    public String deletePost(Long id);

}
