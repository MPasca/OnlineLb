package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

public class Book extends Material{
    private String title;
    private String author;
    private String publisher;
    private int year;
    private String ISBN;
    private String cover;

    public Book(Long id, String name, String title, String author, String publisher,
                int year, String ISBN, String cover) {
        super(id, name, "book");

        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.ISBN = ISBN;
        this.cover = cover;
    }
}
