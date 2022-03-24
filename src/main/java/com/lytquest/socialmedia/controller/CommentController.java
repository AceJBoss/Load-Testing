package com.lytquest.socialmedia.controller;

import com.lytquest.socialmedia.dto.CommentResponse;
import com.lytquest.socialmedia.entity.Comment;
import com.lytquest.socialmedia.exception.ResourceNotFoundException;
import com.lytquest.socialmedia.service.impl.CommentServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private CommentServiceImpl csi;

    CommentController(CommentServiceImpl csi){
        this.csi = csi;
    }

    @PostMapping("/post-comment/{postId}")
    public Comment createComment(@RequestBody Comment comment, @PathVariable Long postId) throws ResourceNotFoundException {
        return csi.createComment(comment, postId);
    }

    @GetMapping("/fetch-comment/{postId}")
    public List<Comment> fetchCommentByPostId(@PathVariable Long postId){
        return csi.findByPostId(postId);
    }

}
