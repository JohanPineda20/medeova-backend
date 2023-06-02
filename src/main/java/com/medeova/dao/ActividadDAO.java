package com.medeova.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeova.model.*;

public interface ActividadDAO extends JpaRepository<Actividad, Integer>
{
	@Query(value = "SELECT ALL * FROM actividad WHERE id_tema = :id_tema", nativeQuery = true)
    public List<Actividad> findByTema(@Param("id_tema") Integer id);
	
	@Query(value = "SELECT a.* FROM actividad a JOIN tema t ON a.id_tema = t.id_tema " +
					"JOIN unidad u ON t.id_unidad = u.id_unidad WHERE u.id_unidad = :id", nativeQuery = true)
	public List<Actividad> findByUnidad(@Param("id") Integer id);
	
	@Query(value = "SELECT a.* FROM actividad a JOIN (" +
			"SELECT da.id_actividad FROM detalle_actividad da " +
			"GROUP BY da.id_actividad HAVING COUNT(*) = (" +
			"SELECT COUNT(*) FROM detalle_rol WHERE id_rol = 2)) " +
			"AS subquery ON a.id_actividad = subquery.id_actividad", nativeQuery = true)
	public List<Actividad> getCompletadas();
	
	@Query(value = "SELECT a.* FROM actividad a JOIN (" +
					"SELECT da.id_actividad FROM detalle_actividad da WHERE da.id_actividad = :id " +
					"GROUP BY da.id_actividad HAVING COUNT(*) = (" +
					"SELECT COUNT(*) FROM detalle_rol WHERE id_rol = 2)) " +
					"AS subquery ON a.id_actividad = subquery.id_actividad", nativeQuery = true)
	public Actividad isCompletada(@Param("id") Integer id);
	
	@Query(value = "SELECT a.* FROM actividad a JOIN tema t ON a.id_tema = t.id_tema JOIN " +
					"unidad u ON t.id_unidad = u.id_unidad WHERE u.id_unidad = :id AND EXISTS (SELECT 1 FROM " +
					"detalle_actividad da WHERE da.id_actividad = a.id_actividad HAVING COUNT(*) = (SELECT "+
					"COUNT(DISTINCT id_usuario) FROM detalle_rol WHERE id_rol = 2))", nativeQuery = true)
	public List<Actividad> listarCompletadasByUnidad(@Param("id") Integer id);
	
	
	@Query(value = "SELECT (SELECT COUNT(id_actividad) * 100 FROM detalle_actividad WHERE id_actividad = :id) / " +
					"(SELECT COUNT(*) FROM detalle_rol WHERE id_rol=2)", nativeQuery = true)
	public Double getPorcentaje(@Param("id") Integer id);
	
	@Query(value = "SELECT AVG(dificultad) FROM detalle_actividad where id_actividad = :id", nativeQuery = true)
	public Double getPromedioDificultad(@Param("id") Integer id);
	
	
}
