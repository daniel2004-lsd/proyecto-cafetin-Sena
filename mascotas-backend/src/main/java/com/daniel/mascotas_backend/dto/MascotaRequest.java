package com.daniel.mascotas_backend.dto;

import lombok.Data;

@Data
public class MascotaRequest {
    private String nombre;
    private String especie;
    private String raza;
    private Integer edad;
    private Long duenoId;  // ← ID del dueño existente
}