package com.medeova.dao;

import com.medeova.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolDAO extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombre(String nombre);
}
