package com.auoia.forum.controller;


import com.auoia.forum.model.Post;
import com.auoia.forum.service.PostService;
import com.auoia.forum.service.TopicService;
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
    TopicService topicService;

    public PostController(PostService postService, TopicService topicService) {
        this.postService = postService;
        this.topicService = topicService;
    }

    @GetMapping
    public List<Post> getAllComments(@PathVariable Long topicId) {
        return topicService.getTopicById(topicId).getPostList();
    }

    @PostMapping(path="/create")
    public void createPost(@PathVariable Long topicId, @RequestBody Post newPost) {
        postService.savePost(topicId, newPost);
    }
}
