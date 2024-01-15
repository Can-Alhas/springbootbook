package com.canalhas.project.springbootbook.repository;

import com.canalhas.project.springbootbook.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    @Query("{ '$or': [ { 'title' : { '$regex' : ?0, '$options' : 'i' } }, { 'author' : { '$regex' : ?0, '$options' : 'i' } }, { 'category' : { '$regex' : ?0, '$options' : 'i' } } ] }")
    List<Book> findByTitleOrAuthorOrCategoryRegexIgnoreCase(String keyword);

    Optional<Book> findByTitle(String bookName);
}

