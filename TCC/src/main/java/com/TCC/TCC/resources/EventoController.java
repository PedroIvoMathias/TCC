package com.TCC.TCC.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public ResponseEntity<Evento> create(@RequestBody Evento evento){
		Evento obj = service.create(evento);
		return new ResponseEntity<>(obj, HttpStatus.CREATED);
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


	@PutMapping(value = "/{id}")
	public ResponseEntity<Evento> update(@PathVariable Long id, @RequestBody Evento evento){
		evento.setId(id);
		Evento updatedEvento = service.update(evento);
		return ResponseEntity.ok().body(updatedEvento);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
