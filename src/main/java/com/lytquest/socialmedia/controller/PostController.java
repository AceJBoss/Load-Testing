package com.lytquest.socialmedia.controller;

import com.lytquest.socialmedia.entity.Post;
import com.lytquest.socialmedia.service.impl.PostServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private PostServiceImpl psi;
    PostController(PostServiceImpl psi){
        this.psi = psi;
    }

    @PostMapping("/create")
    public Post createPost(@RequestBody Post post){
        return psi.createPost(post);
    }

    @GetMapping("/all-post")
    public List<Post> getPost(){
        return psi.getPosts();
    }

    @PutMapping("/update/{id}")
    public Post updatePost(@RequestBody Post post, @PathVariable Long id){
        return psi.updatePost(post, id);
    }

    @GetMapping("post/{id}")
    public Post getPost(@PathVariable  Long id){
        return psi.fetchAPost(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id){
        psi.deletePost(id);
        return "Post Deleted Successfully.";
    }
}
