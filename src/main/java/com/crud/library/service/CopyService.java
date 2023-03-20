package com.crud.library.service;

import com.crud.library.controller.NotFoundException;
import com.crud.library.domain.Copy;
import com.crud.library.repository.CopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CopyService {

    private final CopyRepository repository;

    public Copy findCopyById(final int id) throws NotFoundException {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Copy saveCopy(final Copy copy) {
        return repository.save(copy);
    }
}
