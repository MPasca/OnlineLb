package com.example.demo.Repos;

import com.example.demo.Model.Reader;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Reader repo hc.
 */
@Repository
public class ReaderRepoHC implements ReaderRepo{
    /**
     * The Reader list.
     */
    List<Reader> readerList = new ArrayList<>();

    /**
     * Instantiates a new Reader repo hc.
     */
    public ReaderRepoHC(){
        Reader reader1 = new Reader();
        reader1.setId(1L);
        reader1.setFirstName("Jane");
        reader1.setLastName("Doe");
        reader1.setPassword("admin");
        reader1.setEmail("jane.doe@email.com");
        reader1.setAddress("1st st, no 15");
        reader1.setTelephone("07123456");

        readerList.add(reader1);

        Reader reader2 = new Reader();
        reader1.setId(2L);
        reader2.setFirstName("Maria");
        reader2.setLastName("Pasca");
        reader2.setPassword("admin");
        reader2.setEmail("maria.pasca@email.com");
        reader2.setAddress("str Ceahlau, nr 77");
        reader2.setTelephone("07222222");

        readerList.add(reader2);
    }

    /**
     * Save reader.
     *
     * @param newReader the new reader
     * @return the reader
     */
    public Reader save(Reader newReader){
        readerList.add(newReader);
        return newReader;
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Reader> findAll(){
        return readerList;
    }

    /**
     * Get reader.
     *
     * @param searchedID the searched id
     * @return the reader
     */
    public Reader get(Long searchedID){
        return readerList.get(Math.toIntExact(searchedID));
    }

    /**
     * Delete.
     *
     * @param toDeleteID the to delete id
     */
    public void delete(Long toDeleteID){
        readerList.remove(Math.toIntExact(toDeleteID));
    }
}
