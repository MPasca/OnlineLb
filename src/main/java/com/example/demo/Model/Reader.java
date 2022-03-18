package com.example.demo.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "readers")
public class Reader {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

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
