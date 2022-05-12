package com.example.demo.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * The type Borrowing.
 */
@Data
@Entity
@Table(name = "borrowings")
public class Borrowing {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "readerID")
    private Long readerID;

    @Column(name = "bookID")
    private Long bookID;

    @Column(name = "borrowDate")
    private LocalDate borrowDate;

    @Column(name = "returnDate")
    private Date returnDate;

    @Column(name = "status")
    private boolean isReturned;

    /**
     * Instantiates a new Borrowing.
     *
     * @param readerID the reader id
     * @param bookID   the book id
     */
    public Borrowing(Long readerID, Long bookID){
        this.readerID = readerID;
        this.bookID = bookID;
        this.borrowDate = LocalDate.now();
        this.isReturned = false;
        this.returnDate = null;
    }

    public Borrowing() {

    }
}
