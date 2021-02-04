package com.example.demo.web.rest;

import com.example.demo.service.MyUserService;
import com.example.demo.service.dto.MyUserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserResource {

    private final MyUserService service;

    @GetMapping("/users")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/users/pageable")
    public ResponseEntity<?> getPage(Pageable pageable) {
        return ResponseEntity.ok(service.getPage(pageable));
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<?> getByUsername(@PathVariable String username) {
        return ResponseEntity.ok(service.getByUsername(username));
    }

    @PostMapping("/users")
    public ResponseEntity<MyUserDTO> create(@RequestBody MyUserDTO user) {
        return new ResponseEntity<>(service.create(user), HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<MyUserDTO> update(@RequestBody MyUserDTO user, @PathVariable Long id) {
        return ResponseEntity.ok(service.update(id, user));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(Collections.emptyMap()); // --> {}
    }

}
