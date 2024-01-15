package com.canalhas.project.springbootbook.controller;

import com.canalhas.project.springbootbook.model.Rate;
import com.canalhas.project.springbootbook.service.BookService;
import com.canalhas.project.springbootbook.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rates")
public class RateController {

    private final RateService rateService;
    private final BookService bookService;

    @Autowired
    public RateController(RateService rateService, BookService bookService) {
        this.rateService = rateService;
        this.bookService = bookService;
    }

    @PostMapping("/rateIt/{bookId}")
    public ResponseEntity<String> rateBook(@PathVariable String bookId, @RequestBody Rate rate) {

        rateService.rateBook(bookId, rate);


        bookService.updateAverageRate(bookId);

        return ResponseEntity.status(HttpStatus.CREATED).body("Book rated successfully.");
    }

    @GetMapping("/averageRating/{bookId}")
    public ResponseEntity<Float> getAverageRating(@PathVariable String bookId) {

        float averageRating = bookService.calculateAverageRating(bookId);
        return ResponseEntity.ok(averageRating);
    }


}
