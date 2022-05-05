package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

/**
 * The type Admin.
 */
@Data
@Entity
@Table(name = "admins")
public
class Admin extends User {

    /**
     * id is marked as an auto-incremented primary key
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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


    /**
     * Instantiates a new Admin.
     */
    public Admin() {

    }

    /**
     * Instantiates a new Admin.
     *
     * @param email     the email
     * @param password  the password
     * @param firstName the first name
     * @param lastName  the last name
     */
    public Admin( String email, String password, String firstName, String lastName){
        super(email, password, firstName, lastName);
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
