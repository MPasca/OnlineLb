package com.example.demo.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "books")
public class Book{
    @Id
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "genre")
    private String genre;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "year")
    private int year;

    @Column(name = "ISBN")
    private String ISBN;

    @Column(name = "cover")
    private String cover;

    @Column(name = "isBorrowed")
    private boolean isBorrowed;
}
