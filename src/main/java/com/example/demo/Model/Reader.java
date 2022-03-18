package com.example.demo.Model;

import lombok.Data;

import javax.persistence.*;

/**
 * contains all the attributes for a Reader obj
 * the fields are equivalent with what is in the DB
 *
 * @Data: autogenerates getters, setters and constructors
 * @Entity: marks it as an Table entity
 * @Table: marks it as a "readers" table entity
 */
@Data
@Entity
@Table(name = "readers")
public class Reader {

    /**
     * id is marked as an auto-incremented primary key
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    /**
     * for all fields, it marks the column equivalent in the DB
     */

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "telephone")
    private String telephone;
}
