package com.example.demo.Service;

import com.example.demo.Model.Book;
import com.example.demo.Model.Borrowing;
import com.example.demo.Repos.BorrowingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * The type Borrowing service.
 */
@Service
public class BorrowingService implements IBorrowingService{
    @Autowired
    private BorrowingRepo borrowingRepo;

    @Override
    public Borrowing saveBorrowing(Borrowing newBorrowing) {
        return borrowingRepo.save(newBorrowing);
    }

    @Override
    public List<Borrowing> getBorrowingList() {
        return (List<Borrowing>) borrowingRepo.findAll();
    }

    @Override
    public Borrowing getBorrowingByID(Long id) {
        return borrowingRepo.findById(id).get();
    }

    @Override
    public Borrowing updateBorrowing(Borrowing toUpdate, Long borrowingID) {
        Borrowing updatedBorrowing = borrowingRepo.findById(borrowingID).get();

        if(Objects.nonNull(toUpdate.getReturnDate())){
            updatedBorrowing.setReturnDate(toUpdate.getReturnDate());
        }

        updatedBorrowing.setReturned(toUpdate.isReturned());

        return borrowingRepo.save(updatedBorrowing);
    }

    @Override
    public void deleteBorrowing(Long toDeleteID) {
        borrowingRepo.deleteById(toDeleteID);
    }
}
