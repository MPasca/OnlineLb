package com.example.demo.Controllers;

import com.example.demo.Model.Book;
import com.example.demo.Service.BookService;
import com.example.demo.Service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private IBookService bookService;

    // Create
    @PostMapping("/books")
    public Book createBook(@RequestBody Book newBook){
        return bookService.saveBook(newBook);
    }

    // Read
    @GetMapping("/books")
    public List<Book> fetchBooks(){
        return bookService.getBookList();
    }

    // Update
    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book toUpdate, @PathVariable Long bookID){
        return bookService.updateBook(toUpdate, bookID);
    }

    // Delete
    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable Long toDeleteID){
        bookService.deleteBookById(toDeleteID);

        return "Book " + toDeleteID + " has been successfully deleted";
    }
}
