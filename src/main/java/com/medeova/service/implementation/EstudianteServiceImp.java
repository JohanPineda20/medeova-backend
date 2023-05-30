package com.medeova.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.medeova.dao.*;
import com.medeova.model.*;
import com.medeova.service.EstudianteService;

@Service
public class EstudianteServiceImp implements EstudianteService {

	private EstudianteDAO estudianteDAO;

    @Override
    public Usuario guardar(Usuario estudiante) {
        try{
            //estudiante.setClave(encriptar(estudiante.getClave(),"9sa87yh#f!gqunfp98hy!!awo098#*ahis"));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
        return estudianteDAO.save(estudiante);
    }

    @Override
    public Usuario loginEstudiante(String email, String clave) throws Exception {
        
        //String claveDescifrada = desencriptar(loginEstudiante.getClave(),"9sa87yh#f!gqunfp98hy!!awo098#*ahis");
        //if(clave.equals(claveDescifrada)
            return null;
        
        //return null;
    }

	@Override
	public List<Usuario> getEstudiantes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findById(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}