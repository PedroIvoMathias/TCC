package com.TCC.TCC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TCC.TCC.entities.Ingresso;

@Repository
public interface IngressoRepository extends JpaRepository<Ingresso, Long> {

}
