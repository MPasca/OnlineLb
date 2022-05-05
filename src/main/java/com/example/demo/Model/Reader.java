package com.example.demo.Model;

import lombok.Data;

import javax.persistence.*;

/**
 * contains all the attributes for a Reader obj
 * the fields are equivalent with what is in the DB
 *
 * @Entity: marks it as an Table entity
 * @Table: marks it as a "readers" table entity
 */
@Data
@Entity
@Table(name = "readers")
public class Reader extends User{

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

    /**
     * Instantiates a new empty Reader.
     */
    public Reader() {

    }

    /**
     * Instantiates a new Reader.
     *
     * @param email     the email
     * @param password  the password
     * @param firstName the first name
     * @param lastName  the last name
     * @param address   the address
     * @param telephone the telephone
     */
    public Reader(String email, String password, String firstName, String lastName, String address, String telephone){
        super(email, password, firstName, lastName);
        this.email = email;
        this.password = password;

        this.firstName = firstName;
        this.lastName = lastName;

        this.address = address;
        this.telephone = telephone;
    }
}
