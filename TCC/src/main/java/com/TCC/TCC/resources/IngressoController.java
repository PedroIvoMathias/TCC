package com.TCC.TCC.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.TCC.TCC.entities.Ingresso;
import com.TCC.TCC.services.IngressoService;

@RestController
@RequestMapping(value = "/ingressos")
public class IngressoController {

	@Autowired
	private IngressoService service;

	@GetMapping
	public ResponseEntity<List<Ingresso>> findAll() {
		List<Ingresso> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Ingresso> findById(@PathVariable Long id){
		Ingresso obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
