package com.medeova.service;

import java.util.List;

import com.medeova.model.Tema;

public interface MultimediaService 
{
	public void guardar(Tema nuevo);
    public void eliminar(Integer id);
    public Tema encontrar(Integer id);
    public List<Tema> listar();
}