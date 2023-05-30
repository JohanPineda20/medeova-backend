package com.medeova.service;

import java.util.List;

import com.medeova.model.Comentario;

public interface ComentarioService 
{
	public void guardar(Comentario nuevo);
    public void eliminar(Integer id);
    public Comentario encontrar(Integer id);
    public List<Comentario> listar();
    public List<Comentario> listarByUser(String id);
    public List<Comentario> listarByTema(Integer id);
    public List<Comentario> listarByUserAndTema(String user, Integer tema);
}