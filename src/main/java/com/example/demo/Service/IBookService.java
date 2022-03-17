package com.example.demo.Service;

import com.example.demo.Model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBookService {
    Book saveBook(Book newBook);

    List<Book> getBookList();

    Book updateBook(Book toUpdate, Long bookID);

    void deleteBookById(Long toDeleteId);
}
