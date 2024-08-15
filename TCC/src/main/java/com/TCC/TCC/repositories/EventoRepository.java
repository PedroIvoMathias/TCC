package com.TCC.TCC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TCC.TCC.entities.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

}
