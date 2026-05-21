package com.daniel.mascotas_backend.service;

import com.daniel.mascotas_backend.entity.Dueno;
import java.util.List;

public interface DuenoService {
    List<Dueno> obtenerTodos();
    Dueno guardar(Dueno dueno);
}