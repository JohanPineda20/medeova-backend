package com.medeova.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeova.model.*;

public interface SubtemaDAO extends JpaRepository<Subtema, Integer>{
	@Query(value = "SELECT * FROM subtema WHERE id_tema = :id", nativeQuery = true)
    public List<Subtema> getSubtemas(@Param("id") Integer id);
}
