package com.medeova.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medeova.dao.*;
import com.medeova.model.*;
import com.medeova.service.UnidadService;

@Service
public class UnidadServiceImp implements UnidadService 
{
	@Autowired
    private UnidadDAO dao;
	@Autowired
	private TemaDAO temaDao;
	@Autowired
	private ActividadDAO actDao;
    
    @Override
    @Transactional
	public void guardar(Unidad nuevo) {
		this.dao.save(nuevo);		
	}

	@Override
	@Transactional
	public void eliminar(Integer id) {
		this.dao.deleteById(id);		
	}

	@Override
	@Transactional(readOnly = true)
	public Unidad encontrar(Integer id) {
		return this.dao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Unidad> listar() {
		return this.dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tema> listarByTema(Integer id) {
		return temaDao.getTemas(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Actividad> getActividades(Integer id) {
		return actDao.findByUnidad(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Actividad> getActividadesCompletadas(Integer id) {
		return actDao.listarCompletadasByUnidad(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Double getPromedio(Integer id) {
		Double x = actDao.getPromedioDificultadByUnidad(id);
		if(x == null) return 0d;
		return x;
	}
	
}