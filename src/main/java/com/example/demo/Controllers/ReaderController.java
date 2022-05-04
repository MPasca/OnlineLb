package com.example.demo.Controllers;

import com.example.demo.Model.Reader;
import com.example.demo.Service.IReaderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * it connects the front end to the backend
 */
@RestController
public class ReaderController {
    /**
     * singleton for service (we're taking the data from the DB)
     */
    @Autowired
    private IReaderService readerService;

    /**
     * Create reader reader.
     *
     * @param reader - takes the input from @RequestBody and sends it to the Service
     * @return the created reader to the front-end
     * @PostMapping - Create operation we mark it as /readers because it affects the readers DB
     */
    @PostMapping("/readers")
    public Reader createReader(@RequestBody Reader reader){
        return readerService.saveReader(reader);
    }

    /**
     * fetches the existing readers list from the DB and sends it onwards
     *
     * @return list list
     * @GetMappping - Read operation
     */
    @GetMapping("/readers")
    public List<Reader> fetchReaderList(){
        return readerService.getReaderList();
    }

    /**
     * Update reader reader.
     *
     * @param toUpdate the to update
     * @param readerID the reader id
     * @return reader reader
     * @PutMapping - Update operation  modifies an existing reader (sent by id) with the sent data
     */
    @PutMapping("/readers/{id}")
    public Reader updateReader(@RequestBody Reader toUpdate, @PathVariable("id") Long readerID){
        return readerService.updateReader(toUpdate, readerID);
    }

    /**
     * Delete reader string.
     *
     * @param readerID the reader id
     * @return string string
     * @DeleteMapping - Delete operation  delete an existing reader sent by id
     */
    @DeleteMapping("/readers/{id}")
    public String deleteReader(@PathVariable("id") Long readerID){
        readerService.deleteReaderById(readerID);

        return "Reader " + readerID + " deleted successfully!";
    }
}
