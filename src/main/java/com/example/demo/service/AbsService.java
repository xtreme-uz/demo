package com.example.demo.service;

import com.example.demo.entity.BaseEntity;
import com.example.demo.service.mapper.BaseMapper;
import com.example.demo.service.dto.DTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbsService<E extends BaseEntity, D extends DTO, R extends JpaRepository<E, Long>, M extends BaseMapper<E, D>> {

    protected final R repository;
    protected final M mapper;

    protected AbsService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public D create(D dto) {
        return mapper.toDto(repository.save(mapper.fromDto(dto)));
    }

    public Page<E> getPage(Pageable pageable) {
        Page<E> all = repository.findAll(pageable);
//        List<E> content = all.getContent();
//        long totalElements = all.getTotalElements();
//        int totalPages = all.getTotalPages();
        return all;
    }

    public List<D> getAll() {
        return mapper.toDto(repository.findAll());
    }

    public D get(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
    }

    public D update(Long id, D dto) {

        if (id == null)
            throw new RuntimeException("User id required");

        E updatable = mapper.fromDto(dto);
        updatable.setId(id);

        return mapper.toDto(repository.save(updatable));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
