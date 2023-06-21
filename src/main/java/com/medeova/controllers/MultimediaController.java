package com.medeova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import com.medeova.model.Multimedia;
import com.medeova.service.MultimediaService;

@RestController
@RequestMapping("/api/multimedia")
@CrossOrigin(origins = "*")
public class MultimediaController 
{
	@Autowired
	private MultimediaService service;
	
	
	@GetMapping
	public ResponseEntity<?> getAll() {	
		return ResponseEntity.ok(service.listar());
	}	
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> get(@PathVariable Integer id) {
		Multimedia x = service.encontrar(id);
		if(x == null) 
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);		
		return ResponseEntity.ok(x);
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Multimedia nuevo) {
		service.guardar(nuevo);
		return ResponseEntity.ok(nuevo);
	}
	
	@PostMapping(path = "/todos")
	public ResponseEntity<?> guardarTodos(@RequestBody Multimedia [] array) {
		for(int i = 0; i<array.length; i++) {
			if(array[i].getIdMultimedia() == null)
				service.guardar(array[i]);
		}
		return ResponseEntity.ok(array);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id) {
		if(service.encontrar(id) == null)
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return ResponseEntity.ok(id);
	}	
}