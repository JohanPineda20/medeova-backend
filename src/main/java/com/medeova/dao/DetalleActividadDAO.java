package com.medeova.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeova.model.*;

public interface DetalleActividadDAO extends JpaRepository<DetalleActividad, DetalleActividadId>
{
	DetalleActividad findByUsuarioAndActividad(String usuario, Integer actividad); 
	List<DetalleActividad> findByUsuario(String usuario); 
	List<DetalleActividad> findByActividad(Integer actividad);
	
	@Query(value = "SELECT ALL * FROM detalle_actividad WHERE id_actividad = :id", nativeQuery = true)
    public List<DetalleActividad> findByIdActividad(@Param("id") Integer id);
	
	@Query(value = "SELECT ALL * FROM detalle_actividad WHERE id_usuario = :id", nativeQuery = true)
    public List<DetalleActividad> findByEstudiante(@Param("id") String id);
	
	@Query(value = "SELECT AVG(da.dificultad) AS dificultad FROM detalle_actividad da JOIN actividad a ON " +
					"a.id_actividad = da.id_actividad JOIN tema t ON a.id_tema = t.id_tema JOIN unidad u ON " +
					"t.id_unidad = u.id_unidad WHERE u.id_unidad = :id HAVING COUNT(*) = (SELECT COUNT(" +
					"dr.id_usuario) FROM usuarios_roles dr WHERE dr.id_rol = 2)", nativeQuery = true)
	public Double getPromedioByUnidad(@Param("id") Integer id);
	
	@Query(value = "SELECT ALL da.* FROM detalle_actividad da JOIN actividad a ON a.id_actividad = da.id_actividad JOIN tema t ON a.id_tema = t.id_tema WHERE da.id_usuario = :codigo AND t.id_unidad = :id", nativeQuery = true)
	public List<DetalleActividad> findByEstudianteAndUnidad(@Param ("codigo") String codigo, @Param ("id") Integer id);
	
	@Query(value = "SELECT ALL da.* FROM detalle_actividad da JOIN actividad a ON a.id_actividad = da.id_actividad WHERE da.id_usuario = :codigo AND a.id_tema = :id", nativeQuery = true)
	public List<DetalleActividad> findByEstudianteAndTema(@Param ("codigo") String codigo, @Param ("id") Integer id);
}
