package com.medeova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import com.medeova.model.Comentario;
import com.medeova.service.ComentarioService;

@RestController
@RequestMapping("/api/comentario")
@CrossOrigin(origins = "*")
public class ComentarioController 
{
	@Autowired
	private ComentarioService service;
	
	@GetMapping
	public ResponseEntity<?> getAll() {	
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> get(@PathVariable Integer id) {
		Comentario x = service.encontrar(id);
		if(x == null) 
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);		
		return ResponseEntity.ok(x);
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Comentario nuevo) {
		service.guardar(nuevo);
		return ResponseEntity.ok(nuevo);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id) {
		if(service.encontrar(id) == null)
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return ResponseEntity.ok(id);
	}
	
	
}
