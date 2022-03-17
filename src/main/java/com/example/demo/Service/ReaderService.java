package com.example.demo.Service;

import com.example.demo.Model.Reader;
import com.example.demo.Repos.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ReaderService implements IReaderService{

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    public Reader saveReader(Reader newReader) {
        return readerRepository.save(newReader);
    }

    @Override
    public List<Reader> getReaderList() {
        return (List<Reader>) readerRepository.findAll();
    }

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

    @Override
    public void deleteReaderById(Long toDeleteId) {
        readerRepository.deleteById(toDeleteId);
    }
}
