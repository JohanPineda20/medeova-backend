package com.medeova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import com.medeova.model.Comentario;
import com.medeova.model.Tema;
import com.medeova.service.ActividadService;
import com.medeova.service.ComentarioService;
import com.medeova.service.TemaService;

@RestController
@RequestMapping("/api/tema")
@CrossOrigin(origins = "*")
public class TemaController 
{
	@Autowired
	private TemaService service;
	
	@Autowired
	private ComentarioService comService;
	
	@Autowired
	private ActividadService actService;
	
	
	@GetMapping(path = "{id}/subtemas")
	public ResponseEntity<?> getSubtemas(@PathVariable Integer id){
		Tema x = service.encontrar(id);
		if(x == null) 
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(service.getSubtemas(id));
	}
	
	@GetMapping(path = "{id}/actividades")
	public ResponseEntity<?> getActivities(@PathVariable Integer id){
		Tema x = service.encontrar(id);
		if(x == null) 
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(actService.listarByTema(id));
	}
	
	@GetMapping(path = "{id}/comentarios")
	public ResponseEntity<?> getComments(@PathVariable Integer id){
		Tema x = service.encontrar(id);
		if(x == null) 
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(comService.listarByTema(id));
	}
	
	@PostMapping(path = "{id}/comentarios")
	public ResponseEntity<?> addComment(@PathVariable Integer id, @RequestBody Comentario nuevo){
		Tema x = service.encontrar(id);
		if(x == null) 
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		nuevo.setTema(x);
		comService.guardar(nuevo);
		return ResponseEntity.ok(nuevo);
	}
	
	@GetMapping
	public ResponseEntity<?> getAll() {	
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> get(@PathVariable Integer id) {
		Tema x = service.encontrar(id);
		if(x == null) 
			return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
		
		return ResponseEntity.ok(x);
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Tema nuevo) {
		service.guardar(nuevo);
		return ResponseEntity.ok(nuevo);
	}
	
	@PostMapping(path = "/{id}")
	public ResponseEntity<?> editar(@PathVariable Integer id, @RequestBody Tema nuevo) {
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
