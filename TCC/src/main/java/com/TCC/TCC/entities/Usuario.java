package com.TCC.TCC.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Usuario implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String senha;


	@Column(unique = true, nullable = false, length = 11)

	private String cpf;

	@Column(nullable = false)
	private String nome;

	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Ingresso> ingressos = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void addIngresso(Ingresso ing) {
		ingressos.add(ing);
	}

	public void removeIngresso(Ingresso ing) {
		ingressos.remove(ing);
	}

	public List<Ingresso> consultaIngressos() {
		return new ArrayList<>(ingressos);
	}

}
