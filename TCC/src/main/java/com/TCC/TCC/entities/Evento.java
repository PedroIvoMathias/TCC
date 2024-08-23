package com.TCC.TCC.entities;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "tb_evento")
public class Evento implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@Column(unique = true, nullable = false)
	private String nome;
	@Column(nullable = false)
	private LocalDate horario;
	@Column(nullable = false)
	private LocalDate data;
	@Column(nullable = false)
	private int quantidadeDeLugares;
	@Column
	private String descricao;
	@Column(nullable = false)
	private String localizacao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "evento")
	private List<Ingresso> ingressos = new ArrayList<>();




	
}
