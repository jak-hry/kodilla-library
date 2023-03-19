package com.crud.library.service;

import com.crud.library.controller.NotFoundException;
import com.crud.library.domain.Reader;
import com.crud.library.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository repository;

    public Reader findReaderById(final int id) throws NotFoundException {
        return repository.findReaderById(id).orElseThrow(NotFoundException::new);
    }

    public Reader saveReader(final Reader reader) {
        return repository.save(reader);
    }

    public void removeReader(final int id) {
        repository.deleteById(id);
    }
}
