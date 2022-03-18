package com.example.demo.Service;

import com.example.demo.Model.Reader;
import com.example.demo.Repos.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * the implementation of the interface IReaderService for
                     *  managing the data in the database
 */
@Service
public class ReaderService implements IReaderService{

    /**
     * the singleton for ReaderRepo
     */
    @Autowired
    private ReaderRepository readerRepository;

    /**
     *
     * @param newReader - takes the new reader and inserts it in the database
     *          readerRepository makes the connection to the Readers table from the DB
     *      save is equivalent to the CREATE query in SQL
     *            it sends the data from the newReader obj to the database
     * @return the newReader for further using it in the logic layer
     */
    @Override
    public Reader saveReader(Reader newReader) {
        return readerRepository.save(newReader);
    }

    /**
     *
     * @return the list with the existing readers from the DB
     */
    @Override
    public List<Reader> getReaderList() {
        return (List<Reader>) readerRepository.findAll();
    }

    /**
     *
     * @param toUpdate - the created Reader obj (toUpdate) - contains all new information for the selected Reader
     * @param readerID - the id of the Reader that needs to be updated
     *      check whether there are any fields containing data so that it can update it in the existing
     *                 Reader obj
     *      if the field is empty, it ignores it
     * @return
     */
    @Override
    public Reader updateReader(Reader toUpdate, Long readerID) {
        Reader updatedReader = readerRepository.findById(readerID).get();

        if(Objects.nonNull(toUpdate.getFirstName())
            && !"".equalsIgnoreCase(toUpdate.getFirstName())){
            updatedReader.setFirstName(toUpdate.getAddress());
        }

        if(Objects.nonNull(toUpdate.getLastName())
                && !"".equalsIgnoreCase(toUpdate.getLastName())){
            updatedReader.setLastName(toUpdate.getLastName());
        }

        if(Objects.nonNull(toUpdate.getEmail())
                && !"".equalsIgnoreCase(toUpdate.getEmail())){
            updatedReader.setEmail(toUpdate.getEmail());
        }

        if(Objects.nonNull(toUpdate.getTelephone())
                && !"".equalsIgnoreCase(toUpdate.getTelephone())){
            updatedReader.setTelephone(toUpdate.getTelephone());
        }

        if(Objects.nonNull(toUpdate.getAddress())
                && !"".equalsIgnoreCase(toUpdate.getAddress())){
            updatedReader.setAddress(toUpdate.getAddress());
        }

        return readerRepository.save(updatedReader);
    }

    /**
     *
     * @param toDeleteId - the id of the Reader that will be deleted
     */
    @Override
    public void deleteReaderById(Long toDeleteId) {
        readerRepository.deleteById(toDeleteId);
    }
}
