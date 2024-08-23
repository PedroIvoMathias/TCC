package com.TCC.TCC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TCC.TCC.entities.Usuario;
import com.TCC.TCC.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository repository;

	@Autowired
	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}

	public Usuario create(Usuario usuario){
		return repository.save(usuario);
	}

	public Usuario update(Usuario usuario){
		return repository.save(usuario);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public List<Usuario> findAll() {
		return repository.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		if(obj.isEmpty()) {
			throw new RuntimeException("Usuário não encontrado");
		}
		return obj.get();
	}

}
