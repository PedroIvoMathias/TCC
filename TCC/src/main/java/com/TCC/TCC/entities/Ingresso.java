package com.TCC.TCC.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JoinColumn(name = "compra_id", nullable = false)
	private Compra compra;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Boolean getMeia() {
		return meia;
	}

	public void setMeia(Boolean meia) {
		this.meia = meia;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public String detalhesIngresso() {
		String eMeia;
		
		if(this.getMeia()){
			eMeia = "É meia";
		}else {
			eMeia = "É inteira";
		}
		return "Valor: " + this.getPreco() + "\nMeia: " + eMeia;
	}
}
