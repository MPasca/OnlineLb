package com.example.demo.Model;

/**
 * The type Material.
 */
public abstract class Material {

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
     * @param name  the name
     * @param categ the categ
     */
    public Material(String name, String categ){
        this.name = name;
        this.categ = categ;
    }

    /**
     * Instantiates a new Material.
     */
    public Material() {

    }
}
