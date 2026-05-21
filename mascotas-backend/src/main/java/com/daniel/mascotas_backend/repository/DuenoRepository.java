package com.daniel.mascotas_backend.repository;

import com.daniel.mascotas_backend.entity.Dueno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DuenoRepository extends JpaRepository<Dueno, Long> {
}