package com.medeova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import com.medeova.model.Unidad;
import com.medeova.service.ActividadService;
import com.medeova.service.DetalleActividadService;
import com.medeova.service.UnidadService;

@RestController
@RequestMapping("/api/unidad")
@CrossOrigin(origins = "*")
public class UnidadController 
{
	@Autowired
	private UnidadService service;
	
	@Autowired
	private ActividadService actService;
	
	@Autowired
	private DetalleActividadService detService;
	
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
		return ResponseEntity.ok(actService.listarByUnidad(id));
	}
	
	@GetMapping(path = "/{id}/actividades/completadas")
	public ResponseEntity<?> getActivitiesCompleted(@PathVariable Integer id){
		Unidad x = service.encontrar(id);
		if(x == null) 
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(actService.listarCompletadasByUnidad(id));
	}
	
	@GetMapping(path = "/{id}/actividades/avg")
	public ResponseEntity<?> getActivitiesAvg(@PathVariable Integer id){
		Unidad x = service.encontrar(id);
		if(x == null) 
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(detService.getPromedioByUnidad(id));
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
		Unidad x = service.encontrar(id);
		if(x == null)
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		
		service.guardar(x);
		return ResponseEntity.ok(x);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id) {
		Unidad x = service.encontrar(id);
		if(x == null)
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		service.eliminar(id);
		return ResponseEntity.ok(x);
	}
	
	
}
