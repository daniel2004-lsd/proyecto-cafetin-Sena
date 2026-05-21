package com.daniel.mascotas_backend.controllers;

import com.daniel.mascotas_backend.entity.Dueno;
import com.daniel.mascotas_backend.service.DuenoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/duenos")
@CrossOrigin(origins = "http://localhost:3000") // por si acaso
public class DuenoController {

    private final DuenoService duenoService;

    public DuenoController(DuenoService duenoService) {
        this.duenoService = duenoService;
    }

    // GET: listar dueños
    @GetMapping
    public List<Dueno> obtenerTodos() {
        return duenoService.obtenerTodos();
    }

    // POST: crear dueño
    @PostMapping
    public Dueno crear(@RequestBody Dueno dueno) {
        return duenoService.guardar(dueno);
    }
}