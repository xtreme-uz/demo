package com.example.demo.web.rest;

import com.example.demo.service.RegionService;
import com.example.demo.service.dto.RegionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RegionResource {

    private final RegionService service;

    @PostMapping("/regions")
    public ResponseEntity<RegionDTO> create(@RequestBody RegionDTO region) {
        return new ResponseEntity<>(service.create(region), HttpStatus.CREATED);
    }

    @GetMapping("/regions")
    public ResponseEntity<List<RegionDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
    //*
    @GetMapping("/regions/{id}")
    public ResponseEntity<RegionDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/regions/{id}")
    public ResponseEntity<RegionDTO> update(@RequestBody RegionDTO user, @PathVariable Long id) {
        return ResponseEntity.ok(service.update(id, user));
    }

    @DeleteMapping("/regions/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(Collections.emptyMap());
    }
}
