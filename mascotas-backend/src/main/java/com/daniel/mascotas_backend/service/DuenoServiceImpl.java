package com.daniel.mascotas_backend.service;

import com.daniel.mascotas_backend.entity.Dueno;
import com.daniel.mascotas_backend.repository.DuenoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuenoServiceImpl implements DuenoService {

    private final DuenoRepository duenoRepository;

    public DuenoServiceImpl(DuenoRepository duenoRepository) {
        this.duenoRepository = duenoRepository;
    }

    @Override
    public List<Dueno> obtenerTodos() {
        return duenoRepository.findAll();
    }

    @Override
    public Dueno guardar(Dueno dueno) {
        return duenoRepository.save(dueno);
    }
}