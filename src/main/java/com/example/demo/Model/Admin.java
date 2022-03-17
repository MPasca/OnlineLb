package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

class Admin extends User {
    private String id;

    protected Admin(String username, String password) {
        super(username, password);
        this.id = "A" + "0001";
    }
}
