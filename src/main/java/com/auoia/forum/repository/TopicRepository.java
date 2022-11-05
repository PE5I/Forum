package com.auoia.forum.repository;

import com.auoia.forum.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    Optional<Topic> findTopicById(Long id);
}
