package com.example.demo.service.mapper;

import java.util.List;

public interface BaseMapper<E, D> {

    D toDto(E entity);
    E fromDto(D dto);

    List<E> fromDto(List<D> dto);
    List<D> toDto(List<E> entity);

}
