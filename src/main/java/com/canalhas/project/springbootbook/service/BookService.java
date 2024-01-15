package com.canalhas.project.springbootbook.service;

import com.canalhas.project.springbootbook.model.Book;
import com.canalhas.project.springbootbook.model.Rate;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();


    List<Book> searchBooksByRegex(String title);

    Book getBookDetails(String bookId);

    void saveOrUpdate(Book book);

    List<Rate> getBookRates(String bookId);

    void updateAverageRate(String bookId);

    float calculateAverageRating(String bookId);


    //*********
}
