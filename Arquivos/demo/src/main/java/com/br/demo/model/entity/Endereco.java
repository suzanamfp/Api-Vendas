package com.br.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Table (name = "endereco")
@Entity
@Data
public class Endereco {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Long id;
	
	@Column (name = "numero")
	private Integer numero;
	

	@Column (name = "complemento")
	private String complemento;
	
	@ManyToOne
	@JoinColumn(name = "id_logradouro_bairro", nullable = false)
	private LogradouroBairro logradouroBairro;
	
	
	@Column(name = "atual", nullable = false)
	private boolean atual;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
