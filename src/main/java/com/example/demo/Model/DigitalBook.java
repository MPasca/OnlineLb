package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

public class DigitalBook extends Book{
    String digitalLink;
    public DigitalBook(Long id, String name, String title, String author,
                       String publisher, int year, String ISBN, String cover,
                       String digitalLink) {
        super(id, name, title, author, publisher, year, ISBN, cover);
        this.digitalLink = digitalLink;
    }
}
