package com.TCC.TCC.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.TCC.TCC.entities.Usuario;
import com.TCC.TCC.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@PostMapping
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
		Usuario obj = service.create(usuario);
		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}


	// PRECISA DE AJUSTES
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario){
		var entity = service.findById(id);
		entity.setNome(usuario.getNome());
		entity.setEmail(usuario.getEmail());
		entity.setSenha(usuario.getSenha());
		entity.setCpf(usuario.getCpf());
		entity.setIngressos(usuario.getIngressos());
		return ResponseEntity.ok().body(usuario);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
