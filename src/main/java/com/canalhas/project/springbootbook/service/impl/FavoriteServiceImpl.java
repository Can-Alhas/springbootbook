package com.canalhas.project.springbootbook.service.impl;

import com.canalhas.project.springbootbook.model.Favorite;
import com.canalhas.project.springbootbook.repository.BookRepository;
import com.canalhas.project.springbootbook.repository.FavoriteRepository;
import com.canalhas.project.springbootbook.repository.UserRepository;
import com.canalhas.project.springbootbook.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final FavoriteRepository favoriteRepository;


    @Override
    public boolean addFavorite(String bookName, String username) {
        Optional<Favorite> existingFavorite = favoriteRepository.findByUsernameAndBookName(username, bookName);

        if (existingFavorite.isEmpty()) {
            Favorite newFavorite = new Favorite();
            newFavorite.setUsername(username);
            newFavorite.setBookName(bookName);
            favoriteRepository.save(newFavorite);
            return true;
        } else {

            return false;
        }
    }

    @Override
    public boolean updateFavoriteStatus(String bookName, String currentUsername, boolean favorite) {
        Optional<Favorite> existingFavorite = favoriteRepository.findByUsernameAndBookName(currentUsername, bookName);

        if (favorite) {

            if (existingFavorite.isEmpty()) {
                Favorite newFavorite = new Favorite();
                newFavorite.setUsername(currentUsername);
                newFavorite.setBookName(bookName);
                favoriteRepository.save(newFavorite);
                return true;
            } else {

                return false;
            }
        } else {
            existingFavorite.ifPresent(favoriteRepository::delete);
            return true;
        }
    }
    @Override
    public List<String> getFavoriteBooks(String username) {
        List<Favorite> favorites = favoriteRepository.findByUsername(username);
        return favorites.stream().map(Favorite::getBookName).collect(Collectors.toList());
    }


}




