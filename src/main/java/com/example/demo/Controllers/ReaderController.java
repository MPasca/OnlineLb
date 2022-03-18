package com.example.demo.Controllers;

import com.example.demo.Model.Reader;
import com.example.demo.Service.ReaderService;
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
    private ReaderService readerService;

    /**
     * @PostMapping - Create operation
     * we mark it as /readers because it affects the readers DB
     *
     * @param reader - takes the input from @RequestBody and sends it to the Service
     * @return the created reader to the front-end
     */
    @PostMapping("/readers")
    public Reader createReader(@RequestBody Reader reader){
        return readerService.saveReader(reader);
    }

    /**
     * @GetMappping - Read operation
     *  fetches the existing readers list from the DB and sends it to the front end
     * @return
     */
    @GetMapping("/readers")
    public List<Reader> fetchReaderList(){
        return readerService.getReaderList();
    }

    /**
     * @PutMapping - Update operation
     *  modifies an existing reader (sent by id) with the sent data
     * @param toUpdate
     * @param readerID
     * @return
     */
    @PutMapping("/readers/{id}")
    public Reader updateReader(@RequestBody Reader toUpdate, @PathVariable("id") Long readerID){
        return readerService.updateReader(toUpdate, readerID);
    }

    /**
     * @DeleteMapping - Delete operation
     *  delete an existing reader sent by id
     * @param readerID
     * @return
     */
    @DeleteMapping("/readers/{id}")
    public String deleteReader(@PathVariable("id") Long readerID){
        readerService.deleteReaderById(readerID);

        return "Reader " + readerID + " deleted successfully!";
    }
}
