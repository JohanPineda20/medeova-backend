package com.medeova.service;

import com.medeova.model.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EstudianteService 
{
    @Transactional
    public Usuario guardar(Usuario nuevo) throws Exception;
    
    @Transactional(readOnly = true)
    public Usuario loginEstudiante(String email, String clave) throws Exception;
    
    @Transactional(readOnly = true)
    public List<Usuario> getEstudiantes();
    
    @Transactional(readOnly = true)
    public Usuario findById(String codigo);
}