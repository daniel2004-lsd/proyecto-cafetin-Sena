package com.daniel.mascotas_backend.dto;

import lombok.Data;

@Data
public class MascotaResponseDTO {
    private Long id;
    private String nombre;
    private String especie;
    private String raza;
    private Integer edad;
    private Long duenoId;
    private String duenoNombre;
}