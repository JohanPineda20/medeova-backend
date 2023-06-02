package com.medeova.controllers;

import com.medeova.dao.EstudianteDAO;
import com.medeova.dto.EstudianteDTO;
import com.medeova.model.Usuario;
import com.medeova.service.EstudianteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estudiante")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class EstudianteController {

    private final EstudianteService estudianteService;

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO>  getEstudiante(@PathVariable String id) {
        Usuario estudiante = estudianteService.findByCodigo(id);
        EstudianteDTO estudianteDTO = new EstudianteDTO(estudiante.getCodigo(),estudiante.getPerNom(),
                estudiante.getPerApell(), estudiante.getSdoNom(), estudiante.getSdoApell(), estudiante.getEmail());
        return ResponseEntity.ok(estudianteDTO);
    }
}
