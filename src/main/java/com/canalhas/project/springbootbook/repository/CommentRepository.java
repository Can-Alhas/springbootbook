package com.canalhas.project.springbootbook.repository;

import com.canalhas.project.springbootbook.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findByBookName(String bookName);
}
