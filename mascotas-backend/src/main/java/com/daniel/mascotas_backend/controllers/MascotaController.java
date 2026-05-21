package com.daniel.mascotas_backend.controllers;

import com.daniel.mascotas_backend.dto.MascotaRequest;
import com.daniel.mascotas_backend.dto.MascotaResponseDTO;
import com.daniel.mascotas_backend.entity.Mascota;
import com.daniel.mascotas_backend.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/mascotas")
@CrossOrigin(origins = "*")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    // GET: listar todas
    @GetMapping
    public List<MascotaResponseDTO> listar() {
        return mascotaService.obtenerTodas()
                .stream()
                .map(this::convertirAResponseDTO)
                .collect(Collectors.toList());
    }

    // GET: obtener por id
    @GetMapping("/{id}")
    public MascotaResponseDTO obtenerPorId(@PathVariable Long id) {
        Mascota mascota = mascotaService.obtenerPorId(id);
        return convertirAResponseDTO(mascota);
    }

    // POST: crear mascota
    @PostMapping
    public MascotaResponseDTO crear(@RequestBody MascotaRequest request) {
        Mascota guardada = mascotaService.crear(request);
        return convertirAResponseDTO(guardada);
    }

    // Mapper ENTITY → DTO
    private MascotaResponseDTO convertirAResponseDTO(Mascota mascota) {
        MascotaResponseDTO dto = new MascotaResponseDTO();
        dto.setId(mascota.getId());
        dto.setNombre(mascota.getNombre());
        dto.setEspecie(mascota.getEspecie());
        dto.setRaza(mascota.getRaza());
        dto.setEdad(mascota.getEdad());

        if (mascota.getDueno() != null) {
            dto.setDuenoId(mascota.getDueno().getId());
            dto.setDuenoNombre(mascota.getDueno().getNombre());
        }

        return dto;
    }
}