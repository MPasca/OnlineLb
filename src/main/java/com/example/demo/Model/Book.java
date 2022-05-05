package com.example.demo.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The type Book.
 */
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

    @Column(name = "is_borrowed")
    private boolean isBorrowed;

    /**
     * Instantiates a new Book.
     */
    public Book(){

    }

    /**
     * Instantiates a new Book.
     *
     * @param title     the title
     * @param author    the author
     * @param genre     the genre
     * @param publisher the publisher
     * @param year      the year
     * @param cover     the cover
     */
    public Book(String title, String author, String genre, String publisher, int year, String cover){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.cover = cover;
        this.isBorrowed = false;
    }

    /**
     * Instantiates a new Book.
     *
     * @param title      the title
     * @param author     the author
     * @param genre      the genre
     * @param publisher  the publisher
     * @param year       the year
     * @param cover      the cover
     * @param isBorrowed the is borrowed
     */
    public Book(String title, String author, String genre, String publisher, int year, String cover, boolean isBorrowed){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.year = year;
        this.cover = cover;
        this.isBorrowed = isBorrowed;
    }

    public String toString(){
        String toReturn = id + " " + title + " " + author + " " + genre + " " + publisher + " " +
                year + " " + ISBN + " " + cover + " " + isBorrowed;
        return toReturn;
    }

}
