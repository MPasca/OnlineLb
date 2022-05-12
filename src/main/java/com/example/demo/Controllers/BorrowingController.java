package com.example.demo.Controllers;

import com.example.demo.BLL.Validators.BorrowValidators.BookValidator;
import com.example.demo.Model.Book;
import com.example.demo.Model.Borrowing;
import com.example.demo.Service.IBookService;
import com.example.demo.Service.IBorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Borrowing controller.
 */
@RestController
public class BorrowingController {
    @Autowired
    private IBorrowingService borrowingService;

    @Autowired
    private IBookService bookService;

    /**
     * Create a new Borrowing instance.
     *
     * @param newBorrowing the element to be created in the DB
     * @return the created element
     */
    @PostMapping("/borrowings")
    public Borrowing createBorrowing(@RequestBody Borrowing newBorrowing){
        if(BookValidator.getInstance().validate(newBorrowing.getBookID())){
            bookService.updateBook(new Book("", "", "", "", "", 0, "", true), newBorrowing.getBookID());
            return borrowingService.saveBorrowing(newBorrowing);
        }
        else{
            throw new IllegalStateException("Book " + newBorrowing.getBookID() + " is already borrowed");
        }
    }

    /**
     * Fetch the borrowing list.
     *
     * @return the list
     */
    @GetMapping("/borrowings")
    public List<Borrowing> fetchBorrowingList(){
        return borrowingService.getBorrowingList();
    }

    /**
     * Fetch borrowing by id.
     *
     * @param toFind the id of the element to find
     * @return the said element
     */
    @GetMapping("/borrowings/{id}")
    public Borrowing fetchBorrowingById(@PathVariable("id") Long toFind){
        return borrowingService.getBorrowingByID(toFind);
    }

    /**
     * return a book.
     *
     * @param borrowing an instance containing all the updated info
     * @param toUpdate  the id of the element to be updated
     * @return the updated element
     */
    @PutMapping("/borrowings/{id}")
    public Borrowing endBorrowing(@RequestBody Borrowing borrowing, @PathVariable("id") Long toUpdate){
        Long bookID = borrowingService.getBorrowingByID(toUpdate).getBookID();
        bookService.updateBook(new Book("", "", "", "", "", 0, "", false), bookID);
        return borrowingService.updateBorrowing(borrowing, toUpdate);
    }

    /**
     * Delete borrowing string.
     *
     * @param toDelete the id of the element to be deleted
     * @return a confirmation message that the element has been deleted
     */
    @DeleteMapping("/borrowings/{id}")
    public String deleteBorrowing(@PathVariable("id") Long toDelete){
        borrowingService.deleteBorrowing(toDelete);
        return "Borrowing " + toDelete + " has been successfully deleted!";
    }
}
