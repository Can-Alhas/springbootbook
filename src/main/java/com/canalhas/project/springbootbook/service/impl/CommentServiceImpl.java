package com.canalhas.project.springbootbook.service.impl;

import com.canalhas.project.springbootbook.model.Comment;
import com.canalhas.project.springbootbook.repository.CommentRepository;
import com.canalhas.project.springbootbook.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public void addComment(String bookName, String username, String commentText) {
        Comment comment = new Comment();
        comment.setBookName(bookName);
        comment.setUsername(username);
        comment.setComment(commentText);
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsByBookName(String bookName) {
        return commentRepository.findByBookName(bookName);
    }
}
