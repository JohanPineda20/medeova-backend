package com.medeova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import com.medeova.model.Unidad;
import com.medeova.service.UnidadService;

@RestController
@RequestMapping("/api/unidad")
@CrossOrigin(origins = "*")
public class UnidadController 
{
	@Autowired
	private UnidadService service;
	
	
	@GetMapping(path = "/{id}/temas")
	public ResponseEntity<?> getTemas(@PathVariable Integer id){
		Unidad x = service.encontrar(id);
		if(x == null) 
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(service.listarByTema(id));
	}
	

	@GetMapping(path = "/{id}/actividades")
	public ResponseEntity<?> getActivities(@PathVariable Integer id){
		Unidad x = service.encontrar(id);
		if(x == null) 
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(service.getActividades(id));
	}
	
	@GetMapping(path = "/{id}/actividades/completadas")
	public ResponseEntity<?> getActivitiesCompleted(@PathVariable Integer id){
		Unidad x = service.encontrar(id);
		if(x == null) 
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(service.getActividadesCompletadas(id));
	}
	
	@GetMapping(path = "/{id}/actividades/avg")
	public ResponseEntity<?> getActivitiesAvg(@PathVariable Integer id){
		Unidad x = service.encontrar(id);
		if(x == null) 
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(service.getPromedio(id));
	}
	
	@GetMapping
	public ResponseEntity<?> getAll() {	
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> get(@PathVariable Integer id) {
		Unidad x = service.encontrar(id);
		if(x == null) 
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);		
		return ResponseEntity.ok(x);
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Unidad nuevo) {
		service.guardar(nuevo);
		return ResponseEntity.ok(nuevo);
	}
	
	@PostMapping(path = "/{id}")
	public ResponseEntity<?> editar(@PathVariable Integer id, @RequestBody Unidad nuevo) {
		if(service.encontrar(id) == null)
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		
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