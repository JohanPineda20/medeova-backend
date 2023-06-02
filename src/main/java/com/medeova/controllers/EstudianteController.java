package com.medeova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import com.medeova.model.Usuario;
import com.medeova.service.EstudianteService;

@RestController
@RequestMapping("/api/estudiante")
@CrossOrigin(origins = "*")
public class EstudianteController 
{
	@Autowired
	private EstudianteService service;
	
	
	@GetMapping(path = "/{id}/actividades")
	public ResponseEntity<?> getActivities(@PathVariable String id) {
		Usuario x = service.encontrar(id);
		if(x == null)
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(service.getActividadesDetalle(id));
	}
	
	@GetMapping(path = "/{id}/progreso")
	public ResponseEntity<?> getProgreso(@PathVariable String id) {
		Usuario x = service.encontrar(id);
		if(x == null)
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(service.getProgreso(id));
	}
	
	@GetMapping(path = "/{codigo}/progreso/{id}")
	public ResponseEntity<?> getProgreso(@PathVariable String codigo, @PathVariable Integer id) {
		Usuario x = service.encontrar(codigo);
		if(x == null)
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(service.getProgresoByUnidad(codigo, id));
	}
	
	@GetMapping
	public ResponseEntity<?> getAll() {	
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> get(@PathVariable String id) {
		Usuario x = service.encontrar(id);
		if(x == null) 
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);		
		return ResponseEntity.ok(x);
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Usuario nuevo) {
		service.guardar(nuevo);
		return ResponseEntity.ok(nuevo);
	}
	
	@PostMapping(path = "/{id}")
	public ResponseEntity<?> editar(@PathVariable String id) {
		Usuario x = service.encontrar(id);
		if(x == null)
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		service.guardar(x);
		return ResponseEntity.ok(x);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> eliminar(@PathVariable String id) {
		Usuario x = service.encontrar(id);
		if(x == null)
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return ResponseEntity.ok(x);
	}
	
	
}
