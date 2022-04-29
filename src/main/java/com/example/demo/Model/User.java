package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The type User.
 */
public abstract class User {
    private Long id;

    /**
     * The Username.
     */
    String username;
    /**
     * The Password.
     */
    String password;

    /**
     * Instantiates a new User.
     *
     * @param username the username
     * @param password the password
     */
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    /**
     * Instantiates a new User.
     */
    public User() {

    }
}
