package com.example.demo.BLL.Validators.BookValidators;

import com.example.demo.BLL.Validators.Validator;
import com.example.demo.Service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The type Isbn validator.
 */
public class ISBNValidator implements Validator<String> {
    private static ISBNValidator isbnValidator = new ISBNValidator();

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Validator<String> getInstance() {
        return isbnValidator;
    }

    private ISBNValidator(){}

    @Autowired
    private IBookService bookService;

    @Override
    public boolean validate(String isbn) {
        if(bookService.getBookByISBN(isbn) != null){
            throw new IllegalArgumentException("A book with this ISBN code already exists");
        }
        return true;
    }
}
