package com.medeova.service;

import com.medeova.model.DetalleActividad;
import com.medeova.model.DetalleActividadId;

import java.util.List;

public interface DetalleActividadService 
{
	public List<DetalleActividad> listar();
	public DetalleActividad encontrar (DetalleActividadId id);
    public void guardar(DetalleActividad nuevo);
    public void eliminar(DetalleActividadId id);
    public List<DetalleActividad> getDetallesByEstudiante(String codigo);
    public List<DetalleActividad> getDetallesByActividad(Integer id);
    public Double getPromedioByUnidad(Integer id);
}