package com.canalhas.project.springbootbook.dto;

import lombok.Data;

@Data
public class FavoriteRequest {

    private String bookName;
    private boolean isFavorite;
}
