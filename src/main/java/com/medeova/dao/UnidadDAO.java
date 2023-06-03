package com.medeova.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeova.model.*;

public interface UnidadDAO extends JpaRepository<Unidad, Integer>
{
	@Query(value = "SELECT * FROM tema WHERE id_unidad = :id", nativeQuery = true)
    public List<Tema> getTemas(@Param("id") Integer id);

}
