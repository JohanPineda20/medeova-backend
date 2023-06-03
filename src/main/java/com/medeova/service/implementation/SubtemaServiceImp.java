package com.medeova.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medeova.dao.*;
import com.medeova.model.*;
import com.medeova.service.SubtemaService;

@Service
public class SubtemaServiceImp implements SubtemaService
{
	@Autowired
    private SubtemaDAO dao;
    
    @Override
    @Transactional
	public void guardar(Subtema nuevo) {
		this.dao.save(nuevo);		
	}

	@Override
	@Transactional
	public void eliminar(Integer id) {
		this.dao.deleteById(id);		
	}

	@Override
	@Transactional(readOnly = true)
	public Subtema encontrar(Integer id) {
		return this.dao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Subtema> listar() {
		return this.dao.findAll();
	}

	@Override
	public List<Subtema> listarByTema(Integer id) {
		return dao.getSubtemas(id);
	}
}