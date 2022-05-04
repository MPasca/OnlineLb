package com.example.demo.Model;

/**
 * The type Material.
 */
public abstract class Material {
    /**
     * The Id.
     */
    Long id;
    /**
     * The Name.
     */
    String name;
    /**
     * The Categ.
     */
    String categ;

    /**
     * Instantiates a new Material.
     *
     * @param id    the id
     * @param name  the name
     * @param categ the categ
     */
    public Material(Long id, String name, String categ){
        this.id = id;
        this.name = name;
        this.categ = categ;
    }

    /**
     * Instantiates a new Material.
     */
    public Material() {

    }
}
