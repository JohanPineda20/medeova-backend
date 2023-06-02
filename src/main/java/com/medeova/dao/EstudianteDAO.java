package com.medeova.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medeova.model.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstudianteDAO extends JpaRepository<Usuario, String>{
    Optional<Usuario> findByCodigo(String codigo);
}
