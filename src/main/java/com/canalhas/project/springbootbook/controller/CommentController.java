package com.canalhas.project.springbootbook.controller;

import com.canalhas.project.springbootbook.dto.CommentRequest;
import com.canalhas.project.springbootbook.model.Comment;
import com.canalhas.project.springbootbook.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/add")
    public ResponseEntity<String> addComment(@RequestBody CommentRequest commentRequest) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String currentUsername = userDetails.getUsername();


        commentService.addComment(commentRequest.getBookName(), currentUsername, commentRequest.getComment());

        return ResponseEntity.ok("Yorum eklendi!");
    }


    @GetMapping("/getCommentsByBookName")
    public ResponseEntity<List<String>> getCommentsByBookName(@RequestParam String bookName) {
        List<Comment> comments = commentService.getCommentsByBookName(bookName);

        List<String> formattedComments = comments.stream().map(Comment::toString).toList();
        return ResponseEntity.ok(formattedComments);
    }
}
