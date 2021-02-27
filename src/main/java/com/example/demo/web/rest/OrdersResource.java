package com.example.demo.web.rest;

import com.example.demo.service.OrderService;
import com.example.demo.service.dto.OrdersDTO;
import com.example.demo.web.rest.vm.OrdersCreateVM;
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
@RequestMapping("/api")
public class OrdersResource  {

    private final OrderService service;

    @PostMapping("/orders")
    public ResponseEntity<OrdersDTO> create(@RequestBody OrdersCreateVM orders){
        return new ResponseEntity<>(service.create(orders), HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrdersDTO>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<OrdersDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<OrdersDTO> update(@RequestBody OrdersDTO orders, @PathVariable Long id){
        return ResponseEntity.ok(service.update(id, orders));
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok(Collections.emptyMap());
    }

    //still experimental
    @PostMapping("/{id}/file/upload")
    public ResponseEntity<OrdersDTO> uploadFile(@PathVariable Long id, @RequestParam MultipartFile file){
        return ResponseEntity.ok(service.fileUpload(id, file));
    }

    @PostMapping("/{id}/file/load")
    public ResponseEntity<Resource> loadFile(@PathVariable Long id, @RequestParam String file){
        return ResponseEntity.ok(service.load(file));
    }
}
