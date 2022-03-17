package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

public class Audio extends Material{
    private String author;
    private String album;

    private String genre;
    private String producers;

    private int length;
    private int year;

    public Audio(Long id, String name, String categ, String author,
                 String album, String genre, String producers, int length, int year) {
        super(id, name, categ);

        this.author = author;
        this.album = album;
        this.genre = genre;
        this.producers = producers;
        this.length = length;
        this.year = year;
    }
}
