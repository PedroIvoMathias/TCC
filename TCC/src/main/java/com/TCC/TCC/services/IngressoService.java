package com.TCC.TCC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TCC.TCC.entities.Ingresso;
import com.TCC.TCC.repositories.IngressoRepository;

@Service
public class IngressoService {

	private final IngressoRepository repository;




	@Autowired
	public IngressoService(IngressoRepository repository) {
		this.repository = repository;
	}

	public Ingresso create(Ingresso ingresso){
		return repository.save(ingresso);
	}

	public Ingresso update(Ingresso ingresso){
		return repository.save(ingresso);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public List<Ingresso> findAll() {
		return repository.findAll();
	}

	public Ingresso findById(Long id) {
		Optional<Ingresso> obj = repository.findById(id);
		if(obj.isEmpty()) {
			throw new RuntimeException("Ingresso não encontrado");
		}
		return obj.get();
	}

}
