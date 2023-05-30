package com.medeova.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeova.model.*;

public interface ComentarioDAO extends JpaRepository<Comentario, Integer>
{
	@Query(value = "SELECT ALL * FROM comentario WHERE id_usuario = :id_usuario", nativeQuery = true)
    List<Comentario> findByUser(@Param("id_usuario") String u);
	
	@Query(value = "SELECT ALL * FROM comentario WHERE id_tema = :id_tema", nativeQuery = true)
    List<Comentario> findByTema(@Param("id_tema") Integer t);
	
	@Query(value = "SELECT ALL * FROM comentario WHERE id_usuario = :id_usuario AND id_tema = :id_tema", nativeQuery = true)
    List<Comentario> findByUserAndTema(@Param("id_usuario") String u, @Param("id_tema") Integer t);	
}
