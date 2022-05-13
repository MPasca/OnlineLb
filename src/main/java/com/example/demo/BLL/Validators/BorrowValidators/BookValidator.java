package com.example.demo.BLL.Validators.BorrowValidators;

import com.example.demo.BLL.Validators.Validator;
import com.example.demo.Service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookValidator implements Validator<Long> {
    private static final BookValidator bookValidator = new BookValidator();
    private BookValidator(){}

    public static Validator<Long> getInstance(){
        return bookValidator;
    }

    @Autowired
    private IBookService bookService;
    
    @Override
    public boolean validate(Long bookID) {
        return bookService.getBookById(bookID) != null;
    }
}
