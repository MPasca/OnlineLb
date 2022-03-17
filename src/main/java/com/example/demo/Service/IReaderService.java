package com.example.demo.Service;

import com.example.demo.Model.Reader;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IReaderService {
    Reader saveReader(Reader newReader);

    List<Reader> getReaderList();

    Reader updateReader(Reader toUpdate, Long readerID);

    void deleteReaderById(Long toDeleteId);
}
