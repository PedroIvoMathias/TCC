package com.TCC.TCC.entities;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tb_compra")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Compra {
	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	//muitas compras para um único usuário
	@ManyToOne 
	@JoinColumn(name = "usuario_id",nullable = false )
	private Usuario proprietario;

	@ManyToOne
	@JoinColumn(name = "evento_id",nullable = false)
	private List<Evento> evento = new ArrayList<>();
	
	@OneToMany(mappedBy = "compra")
	private List<Ingresso> ingressos = new ArrayList<>();
}
