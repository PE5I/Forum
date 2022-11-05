package com.auoia.forum.controller;

import com.auoia.forum.model.Topic;
import com.auoia.forum.service.PostService;
import com.auoia.forum.service.TopicService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/topic")
public class TopicController {

    TopicService topicService;
    PostService postService;

    public TopicController(TopicService topicService, PostService postService) {
        this.topicService = topicService;
        this.postService = postService;
    }

    @GetMapping
    public List<Topic> getAllTopic() {
        return topicService.getAllTopic();
    }

    @GetMapping("/{id}")
    public Topic getTopicById(@PathVariable Long id) {
        return topicService.getTopicById(id);
    }

    @PostMapping
    public void createTopic(@RequestBody Topic newTopic) {
        topicService.saveTopic(newTopic);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicService.deleteTopicById(id);
    }
}
