package com.lytquest.socialmedia.service;

import com.lytquest.socialmedia.entity.Comment;
import com.lytquest.socialmedia.exception.ResourceNotFoundException;

import java.util.List;

public interface CommentService {
    public Comment createComment(Comment comment, Long id) throws ResourceNotFoundException;
    public List<Comment> findByPostId(Long id);
}
