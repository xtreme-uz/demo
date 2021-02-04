package com.example.demo.service;

import com.example.demo.entity.BaseEntity;
import com.example.demo.service.dto.DTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbsService<E extends BaseEntity, D extends DTO, R extends JpaRepository<E, Long>> {

    protected final R repository;

    protected AbsService(R repository) {
        this.repository = repository;
    }

    abstract D toDto(E entity);

    abstract E fromDto(D dto);

    public List<D> toDto(List<E> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<E> fromDto(List<D> dtos) {
        return dtos.stream().map(this::fromDto).collect(Collectors.toList());
    }

    public D create(D dto) {
        return toDto(repository.save(fromDto(dto)));
    }

    public Page<E> getPage(Pageable pageable) {
        Page<E> all = repository.findAll(pageable);
//        List<E> content = all.getContent();
//        long totalElements = all.getTotalElements();
//        int totalPages = all.getTotalPages();
        return all;
    }

    public List<D> getAll() {
        return toDto(repository.findAll());
    }

    public D get(Long id) {
        return toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
    }

    public D update(Long id, D dto) {

        if (id == null)
            throw new RuntimeException("User id required");

        E updatable = fromDto(dto);
        updatable.setId(id);

        return toDto(repository.save(updatable));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
