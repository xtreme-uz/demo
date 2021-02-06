package com.example.demo.web.rest;

import com.example.demo.service.RegionService;
import com.example.demo.service.dto.MyUserDTO;
import com.example.demo.service.dto.RegionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RegionResource {

    private final RegionService service;

    @GetMapping("/regions")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/regions")
    public ResponseEntity<RegionDTO> create(@RequestBody RegionDTO region) {
        return new ResponseEntity<>(service.create(region), HttpStatus.CREATED);
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
