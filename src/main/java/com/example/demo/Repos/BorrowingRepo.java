package com.example.demo.Repos;

import com.example.demo.Model.Borrowing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Borrowing repo.
 */
@Repository
public interface BorrowingRepo extends CrudRepository<Borrowing, Long> {
}
