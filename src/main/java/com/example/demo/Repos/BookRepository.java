package com.example.demo.Repos;

import com.example.demo.Model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * creates the CrudRepository for the Books repo
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
