package com.example.demo.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table
public abstract class Material {
    @Id
    Long id;
    String name;
    String categ;

    public Material(Long id, String name, String categ){
        this.id = id;
        this.name = name;
        this.categ = categ;
    }

    public Material() {

    }
}
