package com.example.demo.web.rest;


import com.example.demo.service.SalesRepService;
import com.example.demo.service.impl.SalesRepServiceImpl;
import com.example.demo.service.dto.SalesRepDTO;
import com.example.demo.web.rest.vm.SalesRepCreateVM;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SalesRepResource {

    private final SalesRepService service;

    @GetMapping("/sales")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/sales")
    public ResponseEntity<SalesRepDTO> create(@RequestBody SalesRepCreateVM vm) {
        return new ResponseEntity<>(service.create(vm), HttpStatus.CREATED);
    }

    @PutMapping("/sales/{id}")
    public ResponseEntity<SalesRepDTO> update(@RequestBody SalesRepDTO user, @PathVariable Long id) {
        return ResponseEntity.ok(service.update(id, user));
    }

    @DeleteMapping("/sales/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(Collections.emptyMap());
    }

}
