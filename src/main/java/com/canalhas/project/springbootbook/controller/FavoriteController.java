package com.canalhas.project.springbootbook.controller;

import com.canalhas.project.springbootbook.dto.FavoriteRequest;
import com.canalhas.project.springbootbook.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@RequiredArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;


    @PostMapping("/add")
    public ResponseEntity<String> addFavorite(@RequestBody FavoriteRequest favoriteRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        boolean addedToFavorites = favoriteService.addFavorite(favoriteRequest.getBookName(), currentUsername);

        if (addedToFavorites) {
            return ResponseEntity.ok("Kitap favorilere eklendi!");
        } else {
            return ResponseEntity.badRequest().body("Kitap zaten favorilerde!");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteFavorite(@RequestBody FavoriteRequest favoriteRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        boolean removedFromFavorites = favoriteService.updateFavoriteStatus(
                favoriteRequest.getBookName(), currentUsername, false);

        if (removedFromFavorites) {
            return ResponseEntity.ok("Kitap favorilerden çıkarıldı!");
        } else {
            return ResponseEntity.badRequest().body("Kitap zaten favorilerde değil!");
        }
    }


}

