package com.TCC.TCC.services;

import java.util.List;
import java.util.Optional;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TCC.TCC.entities.Usuario;
import com.TCC.TCC.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository repository;
	private final HazelcastInstance hazelcastInstance;


	@Autowired
	public UsuarioService(UsuarioRepository repository, HazelcastInstance hazelcastInstance) {
		this.repository = repository;
        this.hazelcastInstance = hazelcastInstance;
    }

	public Usuario create(Usuario usuario){
		IMap<Long, Usuario> map = hazelcastInstance.getMap("usuarios");
		if(map.containsKey(usuario.getId())){
			throw new RuntimeException("Usuário já existe");
		}
		Usuario usuarioSalvo = repository.save(usuario);
		map.put(usuarioSalvo.getId(), usuarioSalvo);
		return usuarioSalvo;
	}

	public Usuario update(Usuario usuario){
		Usuario usuarioAtualizado = repository.save(usuario);

		IMap<Long,Usuario> map = hazelcastInstance.getMap("usuarios");
		map.put(usuarioAtualizado.getId(), usuarioAtualizado);

 		return usuarioAtualizado;
	}

	public void delete(Long id) {

		Optional<Usuario> usuarioOptional = repository.findById(id);
		if(usuarioOptional.isEmpty()){
			throw new RuntimeException("Usuário não encontrado");
		}
		repository.deleteById(id);
		IMap<Long, Usuario> map = hazelcastInstance.getMap("usuarios");
		map.remove(id);
	}

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario getUsuarioById(Long id){
		IMap<Long, Usuario> map = hazelcastInstance.getMap("usuarios");
		Usuario usuario = map.get(id);
		if(usuario == null){
			usuario = findUsuarioInSlowSource(id);
			map.put(id, usuario);
		}
		return usuario;
	}

	private Usuario findUsuarioInSlowSource(Long id) {
		try{
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Optional<Usuario> obj = repository.findById(id);
		if(obj.isEmpty()) {
			throw new RuntimeException("Usuário não encontrado");
		}
		return obj.get();
	}

//	public Usuario findById(Long id) {
//		Optional<Usuario> obj = repository.findById(id);
//		if(obj.isEmpty()) {
//			throw new RuntimeException("Usuário não encontrado");
//		}
//		return obj.get();
//	}

}
