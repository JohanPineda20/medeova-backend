package com.medeova.service.implementation;

import java.text.DecimalFormat;
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
	public List<Actividad> listarCompletadas() {
		return dao.getCompletadas();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Actividad> listarCompletadasByUnidad(Integer id) {
		return dao.listarCompletadasByUnidad(id);
	}
	
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


	@Override
	@Transactional(readOnly = true)
	public List<Actividad> listarByUnidad(Integer id) {
		return dao.findByUnidad(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Actividad isCompletada(Integer id) {
		return dao.isCompletada(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Double getPorcentaje(Integer id) {
		Double x = dao.getPorcentaje(id);
		DecimalFormat numberFormat = new DecimalFormat("#.000");
		return Double.parseDouble(numberFormat.format(x));
	}
	
	@Override
	@Transactional(readOnly = true)
	public Double getPromedioDificultad(Integer id) {
		Double x = dao.getPromedioDificultad(id);
		if(x == null) return 0d;
		DecimalFormat numberFormat = new DecimalFormat("#.000");
		return Double.parseDouble(numberFormat.format(x));
	}
}