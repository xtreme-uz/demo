package com.example.demo.web.rest;

import com.example.demo.service.WebEventsService;
import com.example.demo.service.dto.WebEventsDTO;
import com.example.demo.web.rest.vm.WebEventsCreateVM;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class WebEventsResource {

    private final WebEventsService service;

    @PostMapping("/webEvents")
    public ResponseEntity<?> create(@RequestBody WebEventsCreateVM vm){
        return new ResponseEntity<>(service.create(vm), HttpStatus.CREATED);
    }

    @GetMapping("/webEvents/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping("/webEvents")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/webEvents/{id}/")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody WebEventsDTO webDto){
        return ResponseEntity.ok(service.update(id, webDto));
    }

    @DeleteMapping("/webEvents/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok(Collections.emptyMap());
    }


}