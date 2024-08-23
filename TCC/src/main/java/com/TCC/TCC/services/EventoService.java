package com.TCC.TCC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TCC.TCC.entities.Evento;
import com.TCC.TCC.repositories.EventoRepository;

@Service
public class EventoService {

	private final EventoRepository repository;




	@Autowired
	public EventoService(EventoRepository repository) {
		this.repository = repository;
	}

	public Evento create(Evento evento){
		return repository.save(evento);
	}

	public Evento update(Evento evento){
		return repository.save(evento);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public List<Evento> findAll() {
		return repository.findAll();
	}

	public Evento findById(Long id) {
		Optional<Evento> obj = repository.findById(id);
		if(obj.isEmpty()) {
			throw new RuntimeException("Evento não encontrado");
		}
		return obj.get();
	}

}
