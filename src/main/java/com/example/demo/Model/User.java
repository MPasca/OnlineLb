package com.example.demo.Model;

import lombok.Data;

/**
 * The type User.
 */
@Data
public abstract class User {
    /**
     * The Email.
     */
    String email;
    /**
     * The Password.
     */
    String password;
    /**
     * The First name.
     */
    String firstName;
    /**
     * The Last name.
     */
    String lastName;

    /**
     * Instantiates a new User.
     *
     * @param email     the email
     * @param password  the password
     * @param firstName the first name
     * @param lastName  the last name
     */
    public User(String email, String password, String firstName, String lastName){
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Instantiates a new User.
     */
    public User() {

    }
}
