package com.medeova.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medeova.dao.*;
import com.medeova.model.*;
import com.medeova.service.DetalleActividadService;

@Service
public class DetalleActividadServiceImp implements DetalleActividadService 
{
	@Autowired
    private DetalleActividadDAO dao;

	@Override
	@Transactional(readOnly = true)
	public List<DetalleActividad> getDetallesByEstudiante(String codigo) {
		return dao.findByEstudiante(codigo);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<DetalleActividad> getDetallesByActividad(Integer id) {
		return dao.findByActividad(id);
	}

	@Override
    @Transactional
	public void guardar(DetalleActividad nuevo) {
		this.dao.save(nuevo);		
	}

	@Override
	@Transactional
	public void eliminar(DetalleActividadId id) {
		this.dao.deleteById(id);		
	}

	@Override
	@Transactional(readOnly = true)
	public DetalleActividad encontrar(DetalleActividadId id) {
		return this.dao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DetalleActividad> listar() {
		return this.dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Double getPromedioByUnidad(Integer id) {
		return dao.getPromedioByUnidad(id);
	}
}