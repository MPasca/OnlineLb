package com.example.demo.Service;

import com.example.demo.Model.Reader;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IReaderService {
    /**
     *
     * @param newReader - takes the new reader and inserts it in the database
     * @return the newReader if we want to continue working with that Reader Obj in
     *              the previous classes
     */
    Reader saveReader(Reader newReader);

    /**
     *
     * @return returns the reader list from the database
     */
    List<Reader> getReaderList();

    /**
     *
     * @param toUpdate - the created Reader obj (toUpdate) - contains all new information for the selected Reader
     * @param readerID - the id of the Reader that needs to be updated
     * @return  - the existing reader with the updated info
     */
    Reader updateReader(Reader toUpdate, Long readerID);

    /**
     *
     * @param toDeleteId - the id of the Reader that will be deleted
     */
    void deleteReaderById(Long toDeleteId);
}
