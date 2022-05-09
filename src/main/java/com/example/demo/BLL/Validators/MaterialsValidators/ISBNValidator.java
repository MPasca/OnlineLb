package com.example.demo.BLL.Validators.MaterialsValidators;

import com.example.demo.BLL.Validators.Validator;
import com.example.demo.Model.Book;
import com.example.demo.Service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;

public class ISBNValidator implements Validator<Book> {
    private static ISBNValidator isbnValidator = new ISBNValidator();

    public static Validator getInstance() {
        return isbnValidator;
    }

    private ISBNValidator(){}

    @Autowired
    private IBookService bookService;

    @Override
    public boolean validate(Book book) {
        if(bookService.getBookByISBN(book.getISBN()) != null){
            throw new IllegalArgumentException("A book with this ISBN code already exists");
        }
        return false;
    }
}
