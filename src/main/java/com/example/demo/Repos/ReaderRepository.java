package com.example.demo.Repos;

import com.example.demo.Model.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface ReaderRepository extends CrudRepository<Reader, Long> {

}
