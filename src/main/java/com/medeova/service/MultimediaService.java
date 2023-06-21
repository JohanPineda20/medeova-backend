package com.medeova.service;

import java.util.List;

import com.medeova.model.Multimedia;

public interface MultimediaService 
{
	public void guardar(Multimedia nuevo);
    public void eliminar(Integer id);
    public Multimedia encontrar(Integer id);
    public List<Multimedia> listar();
}