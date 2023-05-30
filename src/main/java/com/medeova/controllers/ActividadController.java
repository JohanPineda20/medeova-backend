package com.medeova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import com.medeova.model.Actividad;
import com.medeova.service.ActividadService;

@RestController
@RequestMapping("/api/actividad")
@CrossOrigin(origins = "*")
public class ActividadController 
{
	@Autowired
	private ActividadService service;
	
	@GetMapping
	public ResponseEntity<?> getAll() {	
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> get(@PathVariable Integer id) {
		Actividad x = service.encontrar(id);
		if(x == null) 
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		
		return ResponseEntity.ok(x);
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Actividad nuevo) {
		service.guardar(nuevo);
		return ResponseEntity.ok(nuevo);
	}
	
	@PostMapping(path = "/{id}")
	public ResponseEntity<?> editar(@PathVariable Integer id, @RequestBody Actividad nuevo) {
		Actividad x = service.encontrar(id);
		if(x == null)
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		
		service.guardar(x);
		return ResponseEntity.ok(x);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id) {
		Actividad x = service.encontrar(id);
		if(x == null)
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return ResponseEntity.ok(x);
	}
	
	
}
