package com.medeova.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.medeova.model.TipoActividad;

public interface TipoActividadService 
{
	@Transactional(readOnly = true)
    public List<TipoActividad> getTiposActividades();
}