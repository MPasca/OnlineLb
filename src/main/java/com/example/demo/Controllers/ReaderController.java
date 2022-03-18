package com.example.demo.Controllers;

import com.example.demo.Model.Reader;
import com.example.demo.Service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ReaderController {
    @Autowired
    private ReaderService readerService;

    // Create
    @PostMapping("/readers")
    public Reader createReader(@RequestBody Reader reader){
        return readerService.saveReader(reader);
    }

    // Read
    @GetMapping("/readers")
    public List<Reader> fetchReaderList(){
        return readerService.getReaderList();
    }

    // Update
    @PutMapping("/readers/{id}")
    public Reader updateReader(@RequestBody Reader toUpdate, @PathVariable("id") Long readerID){
        return readerService.updateReader(toUpdate, readerID);
    }

    // Delete
    @DeleteMapping("/readers/{id}")
    public String deleteReader(@PathVariable("id") Long readerID){
        readerService.deleteReaderById(readerID);

        return "Reader " + readerID + " deleted successfully!";
    }
}
