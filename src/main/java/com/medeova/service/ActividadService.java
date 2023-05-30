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
}