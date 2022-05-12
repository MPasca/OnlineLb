package com.example.demo.BLL.Validators.UserValidators;

import com.example.demo.BLL.Validators.Validator;

import java.util.regex.Pattern;

/**
 * The type Telephone validator.
 */
public class TelephoneValidator implements Validator<String> {
    private static final TelephoneValidator telephoneValidator = new TelephoneValidator();

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Validator<String> getInstance() {
        return telephoneValidator;
    }
    private TelephoneValidator(){}

    private static final String TELEPHONE_PATTERN = "(\\+4)?07[0-9]{8}";
    @Override
    public boolean validate(String telephone) {
        Pattern pattern = Pattern.compile(TELEPHONE_PATTERN);
        return pattern.matcher(telephone).matches();
    }
}
