package com.lytquest.socialmedia.service.impl;

import com.lytquest.socialmedia.dto.CommentResponse;
import com.lytquest.socialmedia.entity.Comment;
import com.lytquest.socialmedia.exception.ResourceNotFoundException;
import com.lytquest.socialmedia.repository.CommentRepository;
import com.lytquest.socialmedia.repository.PostRepository;
import com.lytquest.socialmedia.service.CommentService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository){
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }
    @Override
    public Comment createComment(Comment comment, Long postId) throws ResourceNotFoundException {
        return postRepository.findById(postId).map(post -> {
            comment.setPost(post);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

    @Override
    public List<Comment> findByPostId(Long id) {
        return commentRepository.findByPostId(id);
    }
}
