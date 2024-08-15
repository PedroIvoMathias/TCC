package com.TCC.TCC.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
