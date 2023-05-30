package com.medeova.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medeova.dao.*;
import com.medeova.model.*;
import com.medeova.service.TipoActividadService;

@Service
public class TipoActividadServiceImp implements TipoActividadService {

	@Autowired
    private TipoActividadDAO dao;
    
    @Override
    @Transactional(readOnly = true)
	public List<TipoActividad> getTiposActividades() {
		return dao.findAll();
	}
}