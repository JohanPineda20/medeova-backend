package com.medeova.dao;

import com.medeova.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioDAO extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByEmail(String email);
    @Query("SELECT COUNT(u) > 0 FROM Usuario u WHERE u.codigo = ?1")
    boolean existsByCodigo(String username);
    @Query("SELECT COUNT(u) > 0 FROM Usuario u WHERE u.email = ?1")
    boolean existsByEmail(String email);
}
