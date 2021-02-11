package com.example.demo.web.rest;

import com.example.demo.service.RegionService;
import com.example.demo.service.dto.RegionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/regions")
public class RegionResource {

    private final RegionService service;

    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping("/create")
    public ResponseEntity<RegionDTO> create(@RequestBody RegionDTO region) {
        return new ResponseEntity<>(service.create(region), HttpStatus.CREATED);
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
