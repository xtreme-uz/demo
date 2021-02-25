package com.example.demo.service.impl;

import com.example.demo.entity.BaseEntity;
import com.example.demo.mapper.BaseMapper;
import com.example.demo.service.AbsService;
import com.example.demo.service.dto.DTO;
import com.example.demo.service.exception.ObjectFieldRequiredException;
import com.example.demo.service.exception.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbsServiceImpl<E extends BaseEntity, D extends DTO, R extends JpaRepository<E, Long>,
        M extends BaseMapper<E, D>> implements AbsService<E, D> {

    protected final R repository;
    protected final M mapper;

    protected AbsServiceImpl(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public D create(D dto) {
        return mapper.toDto(repository.save(mapper.fromDto(dto)));
    }
    @Override
    public Page<E> getPage(Pageable pageable) {
        Page<E> all = repository.findAll(pageable);
        return all;
    }
    @Override
    public List<D> getAll() {
        return mapper.toDto(repository.findAll());
    }
    @Override
    public D get(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found")));
    }
    @Override
    public D update(Long id, D dto) {

        if (id == null)
            throw new ObjectFieldRequiredException("Object id required");

        E updatable = mapper.fromDto(dto);
        updatable.setId(id);

        return mapper.toDto(repository.save(updatable));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
