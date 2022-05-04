package com.example.demo.Repos;

import com.example.demo.Model.Reader;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * ReaderRepo hard coded info
 */
@Repository
public class ReaderRepoHC {
    /**
     * readers list.
     */
    List<Reader> readerList = new ArrayList<>();

    /**
     * Instantiates a new ReaderRepo
     */
    public ReaderRepoHC(){
        Reader reader1 = new Reader();
        reader1.setFirstName("Jane");
        reader1.setLastName("Doe");
        reader1.setPassword("admin");
        reader1.setEmail("jane.doe@email.com");
        reader1.setAddress("1st st, no 15");
        reader1.setTelephone("07123456");

        readerList.add(reader1);

        Reader reader2 = new Reader();
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
     * return all readers
     *
     * @return the list
     */
    public List<Reader> findAll(){
        return readerList;
    }

    /**
     * Get reader by id
     *
     * @param searchedID the searched id
     * @return the reader
     */
    public Reader get(Long searchedID){
        return readerList.get(Math.toIntExact(searchedID));
    }

    /**
     * Delete reader
     *
     * @param toDeleteID the to delete id
     */
    public void delete(Long toDeleteID){
        readerList.remove(Math.toIntExact(toDeleteID));
    }
}
