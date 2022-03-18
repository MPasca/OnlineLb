package com.example.demo.Repos;

import com.example.demo.Model.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * creates the CrudRepository for the Reader table
 */
@Repository
public
interface ReaderRepository extends CrudRepository<Reader, Long> {

}
