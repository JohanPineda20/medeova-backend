package com.medeova.service;

import com.medeova.model.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EstudianteService 
{

    @Transactional(readOnly = true)
    public List<Usuario> getEstudiantes();
    
    @Transactional(readOnly = true)
    public Usuario findByCodigo(String codigo);
}