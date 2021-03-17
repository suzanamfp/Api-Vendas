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


@Table (name = "Logradouro_Bairro")
@Entity
@Data
public class LogradouroBairro {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_logradouro_bairro")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_logradouro", nullable = false)
	private Logradouro logradouro;
	
	@ManyToOne
	@JoinColumn(name = "id_bairro", nullable = false)
	private Bairro bairro;
	
	@Column (name = "cep")
	private String cep;
}
