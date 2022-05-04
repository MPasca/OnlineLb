package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The type Audio.
 */
public class Audio extends Material{
    private String author;
    private String album;

    private String genre;
    private String producers;

    private int length;
    private int year;

    /**
     * Instantiates a new Audio.
     *
     * @param id        the id
     * @param name      the name
     * @param categ     the categ
     * @param author    the author
     * @param album     the album
     * @param genre     the genre
     * @param producers the producers
     * @param length    the length
     * @param year      the year
     */
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
