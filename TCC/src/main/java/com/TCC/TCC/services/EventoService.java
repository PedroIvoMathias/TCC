package com.TCC.TCC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TCC.TCC.entities.Evento;
import com.TCC.TCC.repositories.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository repository;

	public List<Evento> findAll() {
		return repository.findAll();
	}
	
	public Evento findById(Long id) {
		Optional<Evento> obj = repository.findById(id);
		return obj.get();
	}

}
