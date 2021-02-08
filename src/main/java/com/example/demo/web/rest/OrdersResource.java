package com.example.demo.web.rest;

import com.example.demo.service.OrdersService;
import com.example.demo.service.dto.OrdersDTO;
import com.example.demo.web.rest.vm.OrdersCreateVM;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrdersResource  {

    private final OrdersService service;

    //TODO getById
    @PostMapping("/orders")
    public ResponseEntity<OrdersDTO> create(@RequestBody OrdersCreateVM orders){
        return new ResponseEntity<>(service.create(orders), HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
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
}
