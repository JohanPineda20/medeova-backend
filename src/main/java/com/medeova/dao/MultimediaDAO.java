package com.medeova.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeova.model.*;

public interface MultimediaDAO extends JpaRepository<Multimedia, Integer>{
	@Query(value = "SELECT * FROM multimedia WHERE id_subtema = :id", nativeQuery = true)
    public List<Multimedia> getMultimediaBySubtema(@Param("id") Integer id);
}
