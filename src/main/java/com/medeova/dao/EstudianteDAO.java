package com.medeova.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeova.model.*;

public interface EstudianteDAO extends JpaRepository<Usuario, String>
{
	@Query(value = "SELECT ALL * FROM usuario u JOIN detalle_rol dr ON dr.id_usuario = u.codigo WHERE dr.id_rol = 2", nativeQuery = true)	
	public List<Usuario> findAll();
	
	@Query(value = "SELECT (SELECT COUNT(id_actividad)*100 FROM detalle_actividad WHERE id_usuario = :id)/ (SELECT COUNT(*) FROM actividad)", nativeQuery = true)
	public Double getProgreso(@Param("id") String id);
	
	@Query(value = "SELECT (SELECT COUNT(da.id_actividad)*100 FROM detalle_actividad da JOIN actividad a ON " +
			 		"a.id_actividad = da.id_actividad JOIN tema t ON t.id_tema = a.id_tema WHERE id_usuario =" +
			 		":codigo AND t.id_unidad = :id)/ (SELECT COUNT(*) FROM actividad a JOIN tema t ON " +
			 		"t.id_tema = a.id_tema WHERE t.id_unidad = :id)", nativeQuery = true)
	public Double getProgresoByUnidad(@Param("codigo") String codigo, @Param("id") Integer id);

}
