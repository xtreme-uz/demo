package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AbsService<E, D> {

    D create(D dto);

    Page<E> getPage(Pageable pageable);

    List<D> getAll();

    D get(Long id);

    D update(Long id, D dto);

    void delete(Long id);
}
