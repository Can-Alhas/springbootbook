package com.canalhas.project.springbootbook.service;

import com.canalhas.project.springbootbook.model.Comment;

import java.util.List;

public interface CommentService {
    void addComment(String bookName, String username, String comment);
    List<Comment> getCommentsByBookName(String bookName);
}
