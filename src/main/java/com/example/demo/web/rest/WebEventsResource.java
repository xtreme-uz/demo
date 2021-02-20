package com.example.demo.web.rest;

import com.example.demo.service.WebEventsService;
import com.example.demo.service.dto.WebEventsDTO;
import com.example.demo.web.rest.vm.WebEventsCreateVM;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/webEvents")
public class WebEventsResource {

    private final WebEventsService service;

    @PostMapping("/store-new")
    public ResponseEntity<WebEventsDTO> create(@RequestBody WebEventsCreateVM vm){
        return new ResponseEntity<>(service.create(vm), HttpStatus.CREATED);
    }

    @GetMapping("/get-web-by-id/{id}")
    public ResponseEntity<WebEventsDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<WebEventsDTO>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/{id}/")
    public ResponseEntity<WebEventsDTO> update(@PathVariable Long id, @RequestBody WebEventsDTO webDto){
        return ResponseEntity.ok(service.update(id, webDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok(Collections.emptyMap());
    }


}