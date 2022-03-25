package com.example.demo.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "books")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

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

    public String toString(){
        String toReturn = id + " " + title + " " + author + " " + genre + " " + publisher + " " +
                year + " " + ISBN + " " + cover + " " + isBorrowed;
        return toReturn;
    }

}
