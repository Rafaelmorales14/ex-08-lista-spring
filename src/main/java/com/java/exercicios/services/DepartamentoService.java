package com.java.exercicios.services;

import com.java.exercicios.models.DepartamentoModel;
import com.java.exercicios.repositories.DepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    private final DepartamentoRepository repository;

    public DepartamentoService(DepartamentoRepository repository) {
        this.repository = repository;
    }

    public DepartamentoModel save(DepartamentoModel departamentoModel) {
        return repository.save(departamentoModel);
    }

    public List<DepartamentoModel> findAll() {
        return repository.findAll();
    }

    public Optional<DepartamentoModel> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
