package com.example.demo.web.rest;

import com.example.demo.service.RegionService;
import com.example.demo.service.dto.RegionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/regions")
public class RegionResource {

    private final RegionService service;

    @PostMapping("/store-new")
    public ResponseEntity<RegionDTO> create(@RequestBody RegionDTO region) {
        return new ResponseEntity<>(service.create(region), HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<RegionDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
    //*
    @GetMapping("/get-regions-by-id/{id}")
    public ResponseEntity<RegionDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegionDTO> update(@RequestBody RegionDTO user, @PathVariable Long id) {
        return ResponseEntity.ok(service.update(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(Collections.emptyMap());
    }



}
