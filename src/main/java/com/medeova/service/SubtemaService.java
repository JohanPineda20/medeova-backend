package com.medeova.service;

import java.util.List;

import com.medeova.model.Subtema;

public interface SubtemaService 
{
	public void guardar(Subtema nuevo);
    public void eliminar(Integer id);
    public Subtema encontrar(Integer id);
    public List<Subtema> listar();
}