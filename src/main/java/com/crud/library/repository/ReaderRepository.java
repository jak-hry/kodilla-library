package com.crud.library.repository;

import com.crud.library.domain.Book;
import com.crud.library.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReaderRepository extends CrudRepository<Reader, Integer> {
    Optional<Reader> findReaderById(int id);
}
