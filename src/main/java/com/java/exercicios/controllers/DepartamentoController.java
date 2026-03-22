package com.java.exercicios.controllers;

import com.java.exercicios.models.DepartamentoModel;
import com.java.exercicios.services.DepartamentoService;
import jakarta.servlet.Servlet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/departamentos")
public class DepartamentoController {

    private final DepartamentoService service;

    public DepartamentoController(DepartamentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DepartamentoModel> save(@RequestBody DepartamentoModel departamentoModel) {
        DepartamentoModel request = service.save(departamentoModel);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(departamentoModel.getId())
                .toUri();

        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoModel>> findAll() {
        List<DepartamentoModel> request = service.findAll();

        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoModel> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
