package com.example.demo.web.rest;

import com.example.demo.service.MyUserService;
import com.example.demo.service.dto.MyUserDTO;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserResource {

    private final MyUserService service;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/pageable")
    public ResponseEntity<?> getPage(Pageable pageable) {
        return ResponseEntity.ok(service.getPage(pageable));
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getByUsername(@PathVariable String username) {
        return ResponseEntity.ok(service.getByUsername(username));
    }

    @PostMapping
    public ResponseEntity<MyUserDTO> create(@RequestBody MyUserDTO user) {
        return new ResponseEntity<>(service.create(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MyUserDTO> update(@RequestBody MyUserDTO user, @PathVariable Long id) {
        return ResponseEntity.ok(service.update(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(Collections.emptyMap());
    }

    @PostMapping("/{id}/img/upload")
    public ResponseEntity<?> uploadImg(@PathVariable Long id,
                                       @RequestParam MultipartFile file) {
        return ResponseEntity.ok(service.imgUpload(id, file));
    }

    @PostMapping("/{id}/img/load")
    public ResponseEntity<Resource> loadImg(@PathVariable Long id,
                                            @RequestParam String file) {
        return ResponseEntity.ok(service.load(file));
    }

}
