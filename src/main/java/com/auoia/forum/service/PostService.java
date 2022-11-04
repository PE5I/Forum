package com.auoia.forum.service;

import com.auoia.forum.model.Post;
import com.auoia.forum.model.Topic;
import com.auoia.forum.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    PostRepository postRepository;
    TopicService topicService;

    public PostService(PostRepository postRepository, TopicService topicService) {
        this.postRepository = postRepository;
        this.topicService = topicService;
    }

    public void savePost (Long topicId, Post newPost) {
        //Post post = new Post(parentTopic, newPost);
        Topic parentTopic = topicService.getTopicById(topicId);

        newPost.setTopic(parentTopic);
        parentTopic.getPostList().add(newPost);

        postRepository.save(newPost);
    }

}
