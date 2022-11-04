package com.auoia.forum.service;

import com.auoia.forum.model.Topic;
import com.auoia.forum.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> getAllTopic() {
        return topicRepository.findAll();
    }

    public Topic getTopicById(Long id) {
        Optional<Topic> topic = topicRepository.getTopicById(id);

        if (topic.isEmpty()) {
            throw new IllegalStateException("no topic with id " + id + " exists");
            //handle this error for the user

        }

        return topic.get();
    }

    public void saveTopic(Topic topic) {
        topicRepository.save(topic);
    }
}
