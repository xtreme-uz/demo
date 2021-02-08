package com.example.demo.web.rest;

import com.example.demo.service.AccountsService;
import com.example.demo.service.dto.AccountsDTO;
import com.example.demo.web.rest.vm.AccountsCreateVM;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AccountsResource {

    private final AccountsService service;

    //Should return id and Names columns from Accounts table
    //contact person is not showing
    @GetMapping("/accounts/nameColumns")
    public ResponseEntity<?> getAllNames(){
        return ResponseEntity.ok(service.getIdAndName());
    }


    @GetMapping("/accounts")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping("/accounts/pageable")
    public ResponseEntity<?> getPage(@RequestBody Pageable pageable) {
        return ResponseEntity.ok(service.getPage(pageable));
    }

    @PostMapping("/accounts")
    public ResponseEntity<AccountsDTO> create(@RequestBody AccountsCreateVM vm) {
        return new ResponseEntity<>(service.create(vm), HttpStatus.CREATED);
    }

    @PutMapping("/accounts/{id}")
    public ResponseEntity<AccountsDTO> update(@RequestBody AccountsDTO user, @PathVariable Long id) {
        return ResponseEntity.ok(service.update(id, user));
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(Collections.emptyMap()); // --> {}
    }

}
