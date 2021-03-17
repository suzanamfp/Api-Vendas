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


@Data 
@Table (name = "cliente")
@Entity
public class Cliente {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_cliente")
	private long id;
	
	@Column (name = "cpf_cnpj")
	private long cpfCnpj;
	
	@Column (name = "nome_cliente")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "id_endereco", nullable = false) 
	private Endereco endereco;
 
	
	
}
