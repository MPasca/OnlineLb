package com.example.demo.BLL.Validators.BorrowValidators;

import com.example.demo.BLL.Validators.Validator;
import com.example.demo.Service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The type Book validator.
 * returns false if it's borrowed
 * returns true if it isn't borrowed
 */
public class BookValidator implements Validator<Long> {
    private static final BookValidator bookValidator = new BookValidator();
    private BookValidator(){}

    /**
     * Get instance validator.
     *
     * @return the validator
     */
    public static Validator<Long> getInstance(){
        return bookValidator;
    }

    @Autowired
    private IBookService bookService;

    @Override
    public boolean validate(Long id) {
        return !bookService.getBookById(id).isBorrowed();
    }
}
