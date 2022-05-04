package com.example.demo.Controllers;

import com.example.demo.Model.Book;
import com.example.demo.Service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Book controller.
 */
@RestController
public class BookController {

    @Autowired
    private IBookService bookService;

    /**
     * Add a new book to the DB.
     *
     * @param newBook the book in cause
     * @return the said book once it's saved on the DB
     */
// Create
    @PostMapping("/books")
    public Book createBook(@RequestBody Book newBook){
        return bookService.saveBook(newBook);
    }

    /**
     * Fetch book list.
     *
     * @return the book list
     */
// Read
    @GetMapping("/books")
    public List<Book> fetchBooks(){
        return bookService.getBookList();
    }

    /**
     * Update a book with new information sent by the user.
     *
     * @param toUpdate the to update book
     * @param bookID   the book id to be updated
     * @return the book with the updated information
     */
// Update
    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book toUpdate, @PathVariable Long bookID){
        return bookService.updateBook(toUpdate, bookID);
    }

    /**
     * Delete book string.
     *
     * @param toDeleteID the to delete id
     * @return a message that the book has been deleted
     */
// Delete
    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable Long toDeleteID){
        bookService.deleteBookById(toDeleteID);

        return "Book " + toDeleteID + " has been successfully deleted";
    }
}
