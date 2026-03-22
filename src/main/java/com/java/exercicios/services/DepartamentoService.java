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

    private DepartamentoModel save(DepartamentoModel departamentoModel) {
        return repository.save(departamentoModel);
    }

    private List<DepartamentoModel> findAll() {
        return repository.findAll();
    }

    private Optional<DepartamentoModel> findById(Long id) {
        return repository.findById(id);
    }

    private void deleteById(Long id) {
        repository.deleteById(id);
    }

}
