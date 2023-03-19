package com.crud.library.repository;

import com.crud.library.domain.Copy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CopyRepository extends CrudRepository<Copy, Integer> {
    List<Copy> findAll();
}
