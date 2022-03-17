package com.example.demo.Service;

import com.example.demo.Model.Book;
import com.example.demo.Repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(Book newBook) {
        return bookRepository.save(newBook);
    }

    @Override
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Book toUpdate, Long bookID) {
        Book updatedBook = bookRepository.getById(bookID);

        if(Objects.nonNull(toUpdate.getTitle()) && !"".equalsIgnoreCase(toUpdate.getTitle())){
            updatedBook.setTitle(toUpdate.getTitle());
        }

        if(Objects.nonNull(toUpdate.getAuthor()) && !"".equalsIgnoreCase(toUpdate.getAuthor())){
            updatedBook.setAuthor(toUpdate.getAuthor());
        }

        if(Objects.nonNull(toUpdate.getGenre()) && !"".equalsIgnoreCase(toUpdate.getGenre())){
            updatedBook.setGenre(toUpdate.getGenre());
        }

        if(Objects.nonNull(toUpdate.getPublisher()) && !"".equalsIgnoreCase(toUpdate.getPublisher())){
            updatedBook.setPublisher(toUpdate.getPublisher());
        }

        if(toUpdate.getYear() != 0){
            updatedBook.setYear(toUpdate.getYear());
        }

        if(Objects.nonNull(toUpdate.getISBN()) && !"".equalsIgnoreCase(toUpdate.getISBN())){
            updatedBook.setISBN(toUpdate.getISBN());
        }

        if(Objects.nonNull(toUpdate.getCover()) && !"".equalsIgnoreCase(toUpdate.getCover())){
            updatedBook.setCover(toUpdate.getCover());
        }

        updatedBook.setBorrowed(toUpdate.isBorrowed());

        return bookRepository.save(updatedBook);
    }

    @Override
    public void deleteBookById(Long toDeleteId) {
        bookRepository.deleteById(toDeleteId);
    }
}
