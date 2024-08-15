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

@Entity
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

	public Evento() {
		
	}

	public Evento(long id, String nome, LocalDate horario, LocalDate data, int quantidadeDeLugares, String descricao,
			String localizacao) {
		super();
		Id = id;
		this.nome = nome;
		this.horario = horario;
		this.data = data;
		this.quantidadeDeLugares = quantidadeDeLugares;
		this.descricao = descricao;
		this.localizacao = localizacao;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getHorario() {
		return horario;
	}

	public void setHorario(LocalDate horario) {
		this.horario = horario;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getQuantidadeDeLugares() {
		return quantidadeDeLugares;
	}

	public void setQuantidadeDeLugares(int quantidadeDeLugares) {
		this.quantidadeDeLugares = quantidadeDeLugares;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (Id ^ (Id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (Id != other.Id)
			return false;
		return true;
	}
	
	
}
