package com.TCC.TCC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TCC.TCC.entities.Ingresso;
import com.TCC.TCC.entities.Usuario;
import com.TCC.TCC.repositories.IngressoRepository;

@Service
public class IngressoService {

	@Autowired
	private IngressoRepository repository;

	public List<Ingresso> findAll() {
		return repository.findAll();
	}
	
	public Ingresso findById(Long id) {
		Optional<Ingresso> obj = repository.findById(id);
		return obj.get();
	}

}
