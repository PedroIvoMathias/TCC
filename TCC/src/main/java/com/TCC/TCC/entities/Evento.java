package com.TCC.TCC.entities;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
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
	private LocalDateTime data;

	@Column(nullable = false)
	private int quantidadeDeLugares;

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	private String localizacao;

	@JsonIgnore
	@ManyToMany(mappedBy = "evento")
	private List<Compra> compraEvento = new ArrayList<>();

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

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
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

	public int getQuantidadeDeLugares() {
		return quantidadeDeLugares;
	}

	public void setQuantidadeDeLugares(int lugares) {
		quantidadeDeLugares = lugares;
	}

	public void alterarQuantiLugaresEvento(int novaQuantidade) {
		this.setQuantidadeDeLugares(novaQuantidade);
	}

	public String detalhesEvento() {
		return "Nome " + this.getNome() + "\nData " + this.getData() + "\nlocalização " + this.getLocalizacao()
				+ "\nDescrição do evento: " + this.getDescricao();
	}
}
