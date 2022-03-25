package com.example.demo.Service;

import com.example.demo.Model.Reader;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ReaderServiceHC implements IReaderService{
    List<Reader> readerList = new ArrayList<>();
    private ReaderServiceHC(){
        readerList.add(new Reader(1, "abcd", "Jane", "Doe", "jane.doe@email.com", "1st st, no 15", "07123456"));
        readerList.add(new Reader("admin", "Maria", "Pasca", "maria.pasca@email.com", "str Ceahlau, nr 77", "07222222"));
    }

    @Override
    public Reader saveReader(Reader newReader) {
        readerList.add(newReader);
        return newReader;
    }

    @Override
    public List<Reader> getReaderList() {
        return readerList;
    }

    @Override
    public Reader updateReader(Reader toUpdate, Long readerID) {
        for(Reader r: readerList){
            if(r.getId().equals(readerID)){
                if(Objects.nonNull(toUpdate.getFirstName())
                        && !"".equalsIgnoreCase(toUpdate.getFirstName())){
                    r.setFirstName(toUpdate.getFirstName());
                }

                if(Objects.nonNull(toUpdate.getLastName())
                        && !"".equalsIgnoreCase(toUpdate.getLastName())){
                    r.setLastName(toUpdate.getLastName());
                }

                if(Objects.nonNull(toUpdate.getEmail())
                        && !"".equalsIgnoreCase(toUpdate.getEmail())){
                    r.setEmail(toUpdate.getEmail());
                }

                if(Objects.nonNull(toUpdate.getTelephone())
                        && !"".equalsIgnoreCase(toUpdate.getTelephone())){
                    r.setTelephone(toUpdate.getTelephone());
                }

                if(Objects.nonNull(toUpdate.getAddress())
                        && !"".equalsIgnoreCase(toUpdate.getAddress())){
                    r.setAddress(toUpdate.getAddress());
                }

                return r;
            }
        }
        return null;
    }

    @Override
    public void deleteReaderById(Long toDeleteId) {
        readerList.removeIf(r -> r.getId().equals(toDeleteId));
    }
}
