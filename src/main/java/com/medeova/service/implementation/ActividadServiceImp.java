package com.medeova.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medeova.dao.*;
import com.medeova.model.*;
import com.medeova.service.ActividadService;

@Service
public class ActividadServiceImp implements ActividadService 
{
	@Autowired
    private ActividadDAO dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Actividad> listarByTema(Integer id) {
		return dao.findByTema(id);
	}
    
    @Override
    @Transactional
	public void guardar(Actividad nuevo) {
		this.dao.save(nuevo);		
	}

	@Override
	@Transactional
	public void eliminar(Integer id) {
		this.dao.deleteById(id);		
	}

	@Override
	@Transactional(readOnly = true)
	public Actividad encontrar(Integer id) {
		return this.dao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Actividad> listar() {
		return this.dao.findAll();
	}
}