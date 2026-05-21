package com.daniel.mascotas_backend.service;

import com.daniel.mascotas_backend.dto.MascotaRequest;
import com.daniel.mascotas_backend.entity.Dueno;
import com.daniel.mascotas_backend.entity.Mascota;
import com.daniel.mascotas_backend.repository.DuenoRepository;
import com.daniel.mascotas_backend.repository.MascotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;
    private final DuenoRepository duenoRepository;

    public MascotaService(MascotaRepository mascotaRepository, DuenoRepository duenoRepository) {
        this.mascotaRepository = mascotaRepository;
        this.duenoRepository = duenoRepository;
    }

    public List<Mascota> obtenerTodas() {
        return mascotaRepository.findAll();
    }

    public Mascota guardar(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public Mascota obtenerPorId(Long id) {
        return mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
    }

    public Mascota crear(MascotaRequest request) {
        Dueno dueno = duenoRepository.findById(request.getDuenoId())
                .orElseThrow(() -> new RuntimeException("Dueño no encontrado"));

        Mascota mascota = new Mascota();
        mascota.setNombre(request.getNombre());
        mascota.setEspecie(request.getEspecie());
        mascota.setRaza(request.getRaza());
        mascota.setEdad(request.getEdad());
        mascota.setDueno(dueno);

        return mascotaRepository.save(mascota);
    }
}