package com.auoia.forum.service;

import com.auoia.forum.model.Post;
import com.auoia.forum.model.Topic;
import com.auoia.forum.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    PostRepository postRepository;
    TopicService topicService;

    public PostService(PostRepository postRepository, TopicService topicService) {
        this.postRepository = postRepository;
        this.topicService = topicService;
    }

    public Post getPostById(Long id) {
        Optional<Post> post = postRepository.findPostById(id);

        if (post.isEmpty()) {
            throw new IllegalStateException("no topic with id " + id + " exists");
            //handle this error for the user

        }

        return post.get();
    }

    public List<Post> getAllPostsByTopicId(Long id) {
        return postRepository.findAllPostsByTopicId(id);
    }

    public void savePost (Long topicId, Post newPost) {
        //Post post = new Post(parentTopic, newPost);
        Topic parentTopic = topicService.getTopicById(topicId);

        newPost.setTopic(parentTopic);
        parentTopic.getPostList().add(newPost);
        //newPost.setTopic(parentTopic);

        postRepository.save(newPost);
    }

    public void deletePostById(Long id) {
        postRepository.deleteById(getPostById(id).getId());
    }

}
