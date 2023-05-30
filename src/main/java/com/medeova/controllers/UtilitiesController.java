package com.medeova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeova.service.TipoActividadService;
import com.medeova.service.implementation.UtilitiesService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class UtilitiesController 
{
	private final UtilitiesService service;
	
	@Autowired
	private TipoActividadService tp;
	
	public UtilitiesController(UtilitiesService service) {
        this.service = service;
    }	
	
	@GetMapping(path = "/tp")
	public ResponseEntity<?> tps(){
		System.out.println("***************************WWWWWWWWWWWWWWWWW*********************++");
		return ResponseEntity.ok(tp.getTiposActividades().toString());
	}
	
    @GetMapping(path = "/json")
    public String fetchJsonData() {
    	
        String jsonUrl = "https://github.com/Valentina-03/backend-ovacomputacion/blob/main/data.json";
        System.out.println(service.getJsonData(jsonUrl));
        return service.getJsonData(jsonUrl);
    }
}
