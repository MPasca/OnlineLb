package com.example.demo.Service;

import com.example.demo.Model.Borrowing;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The interface Borrowing service.
 */
@Service
public interface IBorrowingService {
    /**
     * Save borrowing borrowing.
     *
     * @param newBorrowing the new borrowing
     * @return the borrowing
     */
    Borrowing saveBorrowing(Borrowing newBorrowing);

    /**
     * Gets borrowing list.
     *
     * @return the borrowing list
     */
    List<Borrowing> getBorrowingList();

    /**
     * Gets borrowing by id.
     *
     * @param id the id
     * @return the borrowing by id
     */
    Borrowing getBorrowingByID(Long id);

    /**
     * Update borrowing borrowing.
     *
     * @param toUpdate    the to update
     * @param borrowingID the borrowing id
     * @return the borrowing
     */
    Borrowing updateBorrowing(Borrowing toUpdate, Long borrowingID);

    /**
     * Delete borrowing.
     *
     * @param toDeleteID the to delete id
     */
    void deleteBorrowing(Long toDeleteID);
}
