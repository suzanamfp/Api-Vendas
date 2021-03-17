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


@Table (name = "cidade")
@Entity
@Data
public class Cidade {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_cidade")
	private long id;
	
	@Column (name = "nome")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "id_Estado", nullable = false)
	private Estado estado;
	
}
