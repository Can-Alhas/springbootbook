package com.canalhas.project.springbootbook.repository;

import com.canalhas.project.springbootbook.model.Favorite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteRepository extends MongoRepository<Favorite, String> {
    Optional<Favorite> findByUsernameAndBookName(String username, String bookName);
    List<Favorite> findByUsername(String username);
}
