package com.medeova.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medeova.dao.*;
import com.medeova.model.*;
import com.medeova.service.ComentarioService;

@Service
public class ComentarioServiceImp implements ComentarioService 
{
	@Autowired
    private ComentarioDAO dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Comentario> listarByUser(String id) {
		return dao.findByUser(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Comentario> listarByTema(Integer id) {
		return dao.findByTema(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Comentario> listarByUserAndTema(String user, Integer tema) {
		return dao.findByUserAndTema(user, tema);
	}
    
    @Override
    @Transactional
	public void guardar(Comentario nuevo) {
		this.dao.save(nuevo);		
	}

	@Override
	@Transactional
	public void eliminar(Integer id) {
		this.dao.deleteById(id);		
	}

	@Override
	@Transactional(readOnly = true)
	public Comentario encontrar(Integer id) {
		return this.dao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Comentario> listar() {
		return this.dao.findAll();
	}
}