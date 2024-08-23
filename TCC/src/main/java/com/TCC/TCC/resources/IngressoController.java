package com.TCC.TCC.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.TCC.TCC.entities.Ingresso;
import com.TCC.TCC.services.IngressoService;

@RestController
@RequestMapping(value = "/ingressos")
public class IngressoController {

	@Autowired
	private IngressoService service;

	@PostMapping
	public ResponseEntity<Ingresso> create(@RequestBody Ingresso ingresso){
		Ingresso obj = service.create(ingresso);
		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

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


	@PutMapping(value = "/{id}")
	public ResponseEntity<Ingresso> update(@PathVariable Long id, @RequestBody Ingresso ingresso){
		ingresso.setId(id);
		Ingresso updatedIngresso = service.update(ingresso);
		return ResponseEntity.ok().body(updatedIngresso);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
