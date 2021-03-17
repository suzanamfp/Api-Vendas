package com.br.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


	
@Table (name = "logradouro")
@Entity
@Data
public class Logradouro {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_logradouro")
	private Long id;
	
	@Column (name = "nome")
	private Integer numero;
	
	

	
}
