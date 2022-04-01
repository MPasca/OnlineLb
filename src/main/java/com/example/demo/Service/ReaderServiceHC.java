package com.example.demo.Service;

import com.example.demo.Model.Reader;
import com.example.demo.Repos.ReaderRepoHC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * The type Reader service hc.
 * The values are hard coded
 */
@Service
public class ReaderServiceHC implements IReaderService{
    @Autowired
    private ReaderRepoHC readerRepo;

    @Override
    public Reader saveReader(Reader newReader) {
        return readerRepo.save(newReader);
    }

    @Override
    public List<Reader> getReaderList() {
        return readerRepo.findAll();
    }

    @Override
    public Reader updateReader(Reader toUpdate, Long readerID) {
        Reader updatedReader = readerRepo.get(readerID);
        readerRepo.delete(readerID);

        if(Objects.nonNull(toUpdate.getFirstName())
                && !"".equalsIgnoreCase(toUpdate.getFirstName())){
            updatedReader.setFirstName(toUpdate.getFirstName());
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

        return readerRepo.save(updatedReader);
    }

    @Override
    public void deleteReaderById(Long toDeleteId) {
        readerRepo.delete(toDeleteId);
    }
}
