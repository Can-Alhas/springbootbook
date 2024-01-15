package com.canalhas.project.springbootbook.service;

import com.canalhas.project.springbootbook.model.Book;

import com.canalhas.project.springbootbook.repository.BookRepository;
import com.canalhas.project.springbootbook.repository.RateRepository;
import com.canalhas.project.springbootbook.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class BookServiceImplUnitTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private RateRepository rateRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void getAllBooks_shouldReturnListOfBooks() {
        // Arrange
        List<Book> expectedBooks = Arrays.asList(
                new Book("1", "Title 1", "Author 2", "Category 1", 2000, "Summary 1", 5.5),
                new Book("2", "Title 2", "Author 2", "Category 2", 2001, "Summary 2", 6.5)


        );

        Mockito.when(bookRepository.findAll()).thenReturn(expectedBooks);

        // Act
        List<Book> actualBooks = bookService.getAllBooks();

        // Assert
        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    void getBookDetails_shouldReturnBookDetails() {
        // Arrange
        String bookId = "1";
        Book expectedBook = new Book(bookId, "Title 1", "Author 2", "Category 1", 2000, "Summary 1", 5.5);

        Mockito.when(bookRepository.findById(bookId)).thenReturn(Optional.of(expectedBook));

        // Act
        Book actualBook = bookService.getBookDetails(bookId);

        // Assert
        assertEquals(expectedBook, actualBook);
    }

    // Diğer test metotları da benzer şekilde yazılabilir.
}