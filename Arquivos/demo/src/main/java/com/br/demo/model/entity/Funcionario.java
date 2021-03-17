package com.br.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Table (name = "funcionario")
@Entity
@Data
public class Funcionario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcionario")
	private Long id;
	
	@Column (name = "cpf_funcionario")
	private Long cpf;
	
	@Column (name = "nome_funcionario")
	private String nome;
	
	@Column (name = "matricula_funcionario")
	private Long matricula;
	

}
