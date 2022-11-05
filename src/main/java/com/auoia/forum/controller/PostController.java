package com.auoia.forum.controller;


import com.auoia.forum.model.Post;
import com.auoia.forum.service.PostService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/topic/{topicId}/post")
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts(@PathVariable Long topicId) {
        return postService.getAllPostsByTopicId(topicId);
    }

    @PostMapping("/create")
    public void createPost(@PathVariable Long topicId, @RequestBody Post newPost) {
        postService.savePost(topicId, newPost);
    }

    @DeleteMapping(path = "/{postId}")
    public void deletePostById(@PathVariable Long postId) {
        postService.deletePostById(postId);
    }
}
