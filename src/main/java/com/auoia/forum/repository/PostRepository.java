package com.auoia.forum.repository;

import com.auoia.forum.model.Post;
import com.auoia.forum.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Topic> getAllPostsByTopicId(Long id);
}
