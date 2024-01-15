package com.canalhas.project.springbootbook.repository;

import com.canalhas.project.springbootbook.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository underTest;

    @Test
    void findByTitleOrAuthorOrCategoryRegexIgnoreCase() {

        String title = "Title 1";
        String author = "Author 1";
        String category = "Category 1";


        Book book = new Book(
                "1",
                title,
                author,
                category,
                2000,
                "Summary 1",
                5.5
        );
        underTest.save(book);


        List<Book> resultByTitle = underTest.findByTitleOrAuthorOrCategoryRegexIgnoreCase(title);
        List<Book> resultByAuthor = underTest.findByTitleOrAuthorOrCategoryRegexIgnoreCase(author);
        List<Book> resultByCategory = underTest.findByTitleOrAuthorOrCategoryRegexIgnoreCase(category);


        assertThat(resultByTitle).isNotNull();
        assertThat(resultByAuthor).isNotNull();
        assertThat(resultByCategory).isNotNull();
    }

    @Test
    void itShouldCheckIfBookFindByTitle() {

        String title = "Title 1";
        Book book = new Book(
                "1",
                title,
                "Author 1",
                "Category 1",
                2000,
                "Summary 1",
                5.5
        );

        underTest.save(book);



        Optional<Book> books = underTest.findByTitle(title);

        assertThat(books).isNotEmpty();
    }
}