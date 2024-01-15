package com.canalhas.project.springbootbook.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FavoriteService {

    boolean addFavorite(String bookName, String username);

    boolean updateFavoriteStatus(String bookName, String currentUsername, boolean favorite);

    List<String> getFavoriteBooks(String username);
}
