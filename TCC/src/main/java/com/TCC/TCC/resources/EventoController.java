package com.TCC.TCC.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.TCC.TCC.entities.Evento;
import com.TCC.TCC.services.EventoService;

@RestController
@RequestMapping(value = "/eventos")
public class EventoController {

	@Autowired
	private EventoService service;

	@PostMapping
	public ResponseEntity<Evento> insert(@RequestBody Evento obj) {
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Evento>> findAll() {
		List<Evento> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Evento> findById(@PathVariable Long id){
		Evento obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
