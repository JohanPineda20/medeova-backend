package com.medeova.service;

import java.util.List;

import com.medeova.model.Actividad;

public interface ActividadService 
{
	public void guardar(Actividad nuevo);
    public void eliminar(Integer id);
    public Actividad encontrar(Integer id);
    public List<Actividad> listar();
    public List<Actividad> listarByTema(Integer id);
    public List<Actividad> listarByUnidad(Integer id);
    public List<Actividad> listarCompletadas();
    public List<Actividad> listarCompletadasByUnidad(Integer id);
    public Actividad isCompletada(Integer id);
    public Double getPorcentaje(Integer id);
    public Double getPromedioDificultad(Integer id);
}