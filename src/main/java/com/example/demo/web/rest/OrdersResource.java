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
@RequestMapping("/api/orders")
public class OrdersResource  {

    private final OrderService service;

    @PostMapping("/store-new")
    public ResponseEntity<OrdersDTO> create(@RequestBody OrdersCreateVM orders){
        return new ResponseEntity<>(service.create(orders), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<OrdersDTO>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity<OrdersDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdersDTO> update(@RequestBody OrdersDTO orders, @PathVariable Long id){
        return ResponseEntity.ok(service.update(id, orders));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok(Collections.emptyMap());
    }

    //needs a revision
    @PostMapping("/{id}/file/upload")
    public ResponseEntity<OrdersDTO> uploadFile(@PathVariable Long id, @RequestParam MultipartFile file){
        return ResponseEntity.ok(service.fileUpload(id, file));
    }

    @PostMapping("/{id}/file/load")
    public ResponseEntity<Resource> loadFile(@PathVariable Long id, @RequestParam String file){
        return ResponseEntity.ok(service.load(file));
    }
}
