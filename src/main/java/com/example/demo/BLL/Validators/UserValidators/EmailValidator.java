package com.example.demo.BLL.Validators.UserValidators;

import com.example.demo.BLL.Validators.Validator;

import java.util.regex.Pattern;

/**
 * The type Email validator.
 */
public class EmailValidator implements Validator<String> {
    private static final EmailValidator emailValidator = new EmailValidator();

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Validator<String> getInstance() {
        return emailValidator;
    }

    /**
     * Instantiates a new Email validator.
     */
    public EmailValidator(){}

    private static final String EMAIL_PATTERN = "[a-z]+([\\.\\_]?[a-zA-Z0-9]+)*\\@[a-z]+\\.com";

    @Override
    public boolean validate(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);

        return pattern.matcher(email).matches();
    }
}
