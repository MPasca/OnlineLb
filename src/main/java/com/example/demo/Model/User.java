package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public abstract class User {
    @Id
    private Long id;
    String username;
    String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User() {

    }
}
