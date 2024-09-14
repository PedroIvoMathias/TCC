package com.TCC.TCC.entities;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_ingresso")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Ingresso implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(nullable = false)
	private Float preco;
	
	@Column(nullable = false)
	private Boolean meia;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "evento_id")
	private Evento evento;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

}
