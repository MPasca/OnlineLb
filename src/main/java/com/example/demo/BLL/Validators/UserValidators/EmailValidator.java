package com.example.demo.BLL.Validators.UserValidators;

import com.example.demo.BLL.Validators.Validator;
import com.example.demo.Model.User;

import java.util.regex.Pattern;

public class EmailValidator implements Validator<User> {
    private static final EmailValidator emailValidator = new EmailValidator();
    public static Validator getInstance() {
        return emailValidator;
    }
    private EmailValidator(){}

    private static final String EMAIL_PATTERN = "[a-z]+([\\.\\_]?[a-zA-Z0-9]+)*\\@[a-z]+\\.com";

    @Override
    public void validate(User user) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);

        if(!pattern.matcher(user.getEmail()).matches()){
            throw new IllegalArgumentException("Not a valid email address!");
        }
    }
}
