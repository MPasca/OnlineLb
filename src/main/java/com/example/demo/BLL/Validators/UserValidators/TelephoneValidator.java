package com.example.demo.BLL.Validators.UserValidators;

import com.example.demo.BLL.Validators.Validator;
import com.example.demo.Model.Reader;

import java.util.regex.Pattern;

public class TelephoneValidator implements Validator<Reader> {
    private static final TelephoneValidator telephoneValidator = new TelephoneValidator();
    public static Validator getInstance() {
        return telephoneValidator;
    }
    private TelephoneValidator(){}

    private static final String TELEPHONE_PATTERN = "(\\+4)?07[0-9]{8}";
    @Override
    public void validate(Reader reader) {
        Pattern pattern = Pattern.compile(TELEPHONE_PATTERN);
        if(!pattern.matcher(reader.getTelephone()).matches()){
            throw new IllegalArgumentException("Not a valid telephone number!");
        }
    }
}
