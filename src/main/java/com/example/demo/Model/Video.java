package com.example.demo.Model;

public class Video extends Material{
    String director;
    String producers;

    String genre;
    int runtime;
    int year;

    String actors;

    public Video(Long id, String name, String director, String producers, String genre,
                 int runtime, String actors, int year) {
        super(id, name, "video");
        this.director = director;
        this.producers = producers;
        this.genre = genre;
        this.runtime = runtime;
        this.actors = actors;
        this.year = year;
    }
}
