package com.example.demo.Repos;

import com.example.demo.Model.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * creates the CrudRepository for the Admins table
 */
@Repository
public interface AdminRepo extends CrudRepository<Admin, Long> {
}
