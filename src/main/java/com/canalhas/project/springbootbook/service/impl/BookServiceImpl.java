package com.canalhas.project.springbootbook.service.impl;

import com.canalhas.project.springbootbook.model.Book;
import com.canalhas.project.springbootbook.model.Rate;
import com.canalhas.project.springbootbook.repository.BookRepository;
import com.canalhas.project.springbootbook.repository.RateRepository;
import com.canalhas.project.springbootbook.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final RateRepository rateRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookDetails(String bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @Override
    public void saveOrUpdate(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> searchBooksByRegex(String keyword) {
        return bookRepository.findByTitleOrAuthorOrCategoryRegexIgnoreCase(".*" + keyword + ".*");
    }

    @Override
    public List<Rate> getBookRates(String bookId) {
        return rateRepository.findByBookId(bookId);
    }

    @Override
    public void updateAverageRate(String bookId) {
        List<Rate> rates = rateRepository.findByBookId(bookId);
        int totalRates = rates.size();
        float sumRates = (float) rates.stream().mapToDouble(Rate::getRate).sum();



        float averageRate = totalRates > 0 ? sumRates / totalRates : 0;

        Book book = bookRepository.findById(bookId).orElse(null);
        if (book != null) {
            book.setAverageRate(averageRate);
            bookRepository.save(book);
        }
    }

    @Override
    public float calculateAverageRating(String bookId) {
        List<Rate> rates = rateRepository.findByBookId(bookId);
        int totalRates = rates.size();
        float sumRates =(float) rates.stream().mapToDouble(Rate::getRate).sum();

        return totalRates > 0 ? sumRates / totalRates : 0;
    }
}
