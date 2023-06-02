package com.medeova.service.implementation;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.medeova.dao.*;
import com.medeova.model.*;
import com.medeova.service.EstudianteService;

@Service
@AllArgsConstructor
public class EstudianteServiceImp implements EstudianteService {

	private final EstudianteDAO estudianteDAO;


	@Override
	public List<Usuario> getEstudiantes() {
		return null;
	}

	@Override
	public Usuario findByCodigo(String codigo) {
		Optional<Usuario>  estudianteOptional = estudianteDAO.findByCodigo(codigo);
		Usuario estudiante = estudianteOptional
				.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con correo: " + codigo));
		return estudiante;
	}

}