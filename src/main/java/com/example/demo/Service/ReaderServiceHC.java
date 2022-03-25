package com.example.demo.Service;

import com.example.demo.Model.Reader;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Reader service hc.
 * The values are hard coded
 */
@Service
public class ReaderServiceHC implements IReaderService{
    /**
     * The Reader list.
     */
    List<Reader> readerList = new ArrayList<>();
    private ReaderServiceHC(){
        Reader reader1 = new Reader();
        reader1.setFirstName("Jane");
        reader1.setLastName("Doe");
        reader1.setPassword("admin");
        reader1.setEmail("jane.doe@email.com");
        reader1.setAddress("1st st, no 15");
        reader1.setTelephone("07123456");

        Reader reader2 = new Reader();
        reader2.setFirstName("Maria");
        reader2.setLastName("Pasca");
        reader2.setPassword("admin");
        reader2.setEmail("maria.pasca@email.com");
        reader2.setAddress("str Ceahlau, nr 77");
        reader2.setTelephone("07222222");
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
