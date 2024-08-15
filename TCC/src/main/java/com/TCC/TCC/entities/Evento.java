package com.TCC.TCC.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "tb_evento")
public class Evento {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String nome;
	private LocalDate horario;
	private LocalDate data;
	private int quantidadeDeLugares;
	private String descricao;
	private String localizacao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "evento")
	private List<Ingresso> ingressos = new ArrayList<>();




	
}
