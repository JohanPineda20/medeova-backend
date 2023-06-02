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
	
	@GetMapping(path = "/completadas")
	public ResponseEntity<?> getCompletadas(){
		return ResponseEntity.ok(service.listarCompletadas());
	}
	
	@GetMapping(path = "/{id}/estado")
	public ResponseEntity<?> isCompletada(@PathVariable Integer id) {
		if(service.isCompletada(id) == null) return ResponseEntity.ok(false);
		return ResponseEntity.ok(true);
	}
	
	@GetMapping(path = "/{id}/porcentaje")
	public ResponseEntity<?> getPercentage(@PathVariable Integer id) {
		return ResponseEntity.ok(service.getPorcentaje(id));
	}
	
	@GetMapping(path = "/{id}/promedio")
	public ResponseEntity<?> getAverageDifficulty(@PathVariable Integer id) {
		return ResponseEntity.ok(service.getPromedioDificultad(id));
	}
	
	
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
