package com.example.demo.BLL.Validators.BorrowValidators;

import com.example.demo.BLL.Validators.Validator;
import com.example.demo.Service.IReaderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The type Reader validator.
 */
public class ReaderValidator implements Validator<Long> {
    private static final ReaderValidator readerValidator = new ReaderValidator();
    private ReaderValidator() {}

    /**
     * Get instance validator.
     *
     * @return the validator
     */
    public static Validator<Long> getInstance(){
        return readerValidator;
    }

    @Autowired
    private IReaderService readerService;

    @Override
    public boolean validate(Long readerID) {
        return readerService.findReaderById(readerID) != null;
    }
}
