package com.medeova.service.implementation;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medeova.dao.*;
import com.medeova.model.*;
import com.medeova.service.EstudianteService;

@Service
public class EstudianteServiceImp implements EstudianteService 
{
	@Autowired
	private EstudianteDAO dao;

	@Autowired
	private DetalleActividadDAO det_dao;


	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listar() {
		return dao.findAll();
	}

	@Override
	@Transactional
    public Usuario guardar(Usuario nuevo) {
        try{
            //estudiante.setClave(encriptar(estudiante.getClave(),"9sa87yh#f!gqunfp98hy!!awo098#*ahis"));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
        return dao.save(nuevo);
    }
	
	@Override
	@Transactional(readOnly = true)
	public Usuario encontrar(String codigo) {
		return dao.findById(codigo).orElse(null);
	}

	@Override
	@Transactional
	public void eliminar(String codigo) {
		dao.deleteById(codigo);		
	}

    @Override
	@Transactional(readOnly = true)
	public List<DetalleActividad> getActividadesDetalle(String codigo) {
    	return det_dao.findByEstudiante(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DetalleActividad> getActividadesDetalleByUnidad(String codigo, Integer id) {
		return det_dao.findByEstudianteAndUnidad(codigo, id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<DetalleActividad> getActividadesDetalleByTema(String codigo, Integer id) {
		return det_dao.findByEstudianteAndTema(codigo, id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Double getProgresoByUnidad(String codigo, Integer id) {
		return dao.getProgresoByUnidad(codigo, id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Double getProgreso(String codigo) {
		Double x = dao.getProgreso(codigo);
		DecimalFormat numberFormat = new DecimalFormat("#.000");
		return Double.parseDouble(numberFormat.format(x));
	}
}