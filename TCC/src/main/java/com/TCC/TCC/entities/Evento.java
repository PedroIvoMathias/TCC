package com.TCC.TCC.entities;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
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
	private LocalDateTime data;

	@Column(nullable = false)
	private int quantidadeDeLugares;

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	private String localizacao;


}
