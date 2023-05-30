package com.medeova.service;

import java.util.List;

import com.medeova.model.Unidad;

public interface UnidadService 
{
	public void guardar(Unidad nuevo);
    public void eliminar(Integer id);
    public Unidad encontrar(Integer id);
    public List<Unidad> listar();
}