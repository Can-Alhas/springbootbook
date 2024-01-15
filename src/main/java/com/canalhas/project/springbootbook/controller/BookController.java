package com.canalhas.project.springbootbook.controller;

import com.canalhas.project.springbootbook.model.Book;
import com.canalhas.project.springbootbook.model.Rate;
import com.canalhas.project.springbootbook.service.BookService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {


    private final BookService bookService;

    @GetMapping(value = "/getAllBooks")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }



    @GetMapping("/searchByRegex")
    public List<Book> searchBooksByRegex(@RequestParam(required = false) String keyword) {
        return bookService.searchBooksByRegex(keyword);
    }


    @GetMapping("/{bookId}")
    public Book getBookDetails(@PathVariable String bookId) {
        return bookService.getBookDetails(bookId);
    }

    @PostMapping(value = "/save")
    public String saveBook(@RequestBody Book book){
        bookService.saveOrUpdate(book);
        return book.getId();
    }

    @GetMapping("/average-rating/{bookId}")
    public ResponseEntity<Float> getAverageRating(@PathVariable String bookId) {
        float averageRating = bookService.calculateAverageRating(bookId);
        return ResponseEntity.ok(averageRating);
    }

    @PostMapping("/rate")
    public void rateBook(@RequestBody Rate rate) {

        bookService.updateAverageRate(rate.getBookId());
    }


}
