package com.medeova.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeova.model.*;

public interface ActividadDAO extends JpaRepository<Actividad, Integer>{
	@Query(value = "SELECT ALL * FROM actividad WHERE id_tema = :id_tema", nativeQuery = true)
    List<Actividad> findByTema(@Param("id_tema") Integer id);
}
