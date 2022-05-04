package com.example.demo.Model;

/**
 * The type Video.
 */
public class Video extends Material{
    /**
     * The Director.
     */
    String director;
    /**
     * The Producers.
     */
    String producers;

    /**
     * The Genre.
     */
    String genre;
    /**
     * The Runtime.
     */
    int runtime;
    /**
     * The Year.
     */
    int year;

    /**
     * The Actors.
     */
    String actors;

    /**
     * Instantiates a new Video.
     *
     * @param id        the id
     * @param name      the name
     * @param director  the director
     * @param producers the producers
     * @param genre     the genre
     * @param runtime   the runtime
     * @param actors    the actors
     * @param year      the year
     */
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
