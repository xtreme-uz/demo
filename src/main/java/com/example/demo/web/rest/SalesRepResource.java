package com.example.demo.web.rest;


import com.example.demo.service.SalesRepService;
import com.example.demo.service.dto.SalesRepDTO;
import com.example.demo.web.rest.vm.SalesRepCreateVM;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sales")
public class SalesRepResource {

    private final SalesRepService service;

    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping("/create")
    public ResponseEntity<SalesRepDTO> create(@RequestBody SalesRepCreateVM vm) {
        return new ResponseEntity<>(service.create(vm), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalesRepDTO> update(@RequestBody SalesRepDTO user, @PathVariable Long id) {
        return ResponseEntity.ok(service.update(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(Collections.emptyMap());
    }

}
