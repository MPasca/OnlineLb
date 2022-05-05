package com.example.demo.Service;

import com.example.demo.Model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The interface Book service.
 */
@Service
public interface IBookService {
    /**
     * Save book book.
     *
     * @param newBook the new book
     * @return the book
     */
    Book saveBook(Book newBook);

    /**
     * Gets book list.
     *
     * @return the book list
     */
    List<Book> getBookList();

    /**
     * Gets book by id.
     *
     * @param bookId the book id
     * @return the book
     */
    Book getBookById(Long bookId);

    Book getBookByISBN(String ISBN);

    /**
     * Update book book.
     *
     * @param toUpdate the to update
     * @param bookID   the book id
     * @return the book
     */
    Book updateBook(Book toUpdate, Long bookID);

    /**
     * Delete book by id.
     *
     * @param toDeleteId the to delete id
     */
    void deleteBookById(Long toDeleteId);
}
