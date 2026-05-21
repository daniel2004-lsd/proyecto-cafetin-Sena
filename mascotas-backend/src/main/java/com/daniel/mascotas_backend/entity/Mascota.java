package com.daniel.mascotas_backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "mascotas", schema = "mascotas")
@Data
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String especie;
    private String raza;
    private Integer edad;

    @ManyToOne
    @JoinColumn(name = "dueno_id", nullable = false)
    @JsonBackReference   // 👈 AGREGA ESTO
    private Dueno dueno;
}