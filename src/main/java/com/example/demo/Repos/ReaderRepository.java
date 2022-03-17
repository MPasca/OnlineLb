package com.example.demo.Repos;

import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ReadersRepository extends JpaRepository<User,Integer> {
    // SELECT * FROM USERS
    List<User> findAll();
}
