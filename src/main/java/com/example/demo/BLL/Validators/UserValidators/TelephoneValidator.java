package com.example.demo.BLL.Validators.UserValidators;

import com.example.demo.BLL.Validators.Validator;

import java.util.regex.Pattern;

public class TelephoneValidator implements Validator<String> {
    private static final TelephoneValidator telephoneValidator = new TelephoneValidator();
    public static Validator getInstance() {
        return telephoneValidator;
    }
    private TelephoneValidator(){}

    private static final String TELEPHONE_PATTERN = "(\\+4)?07[0-9]{8}";
    @Override
    public boolean validate(String telephone) {
        Pattern pattern = Pattern.compile(TELEPHONE_PATTERN);
        if(!pattern.matcher(telephone).matches()){
            return false;
        }
        return true;
    }
}
