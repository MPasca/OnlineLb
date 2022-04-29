package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

/**
 * The type Admin.
 */
@Data
@Entity
@AllArgsConstructor
@Table(name = "admins")
public
class Admin extends User {

    /**
     * id is marked as an auto-incremented primary key
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private static Long id;

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


    /**
     * Instantiates a new Admin.
     */
    public Admin() {

    }
}
