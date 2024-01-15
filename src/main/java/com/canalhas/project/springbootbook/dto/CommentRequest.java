package com.canalhas.project.springbootbook.dto;

import lombok.Data;

@Data
public class CommentRequest {
    private String bookName;
    private String comment;
}
