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


@Table (name = "fornecedor")
@Entity
@Data
public class Fornecedor {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_fornecedor")
	private long id;
	
	@Column (name = "nome_fornecedor")
	private String nome;
	
	@Column (name = "cnpj_cpf")
	private long cpf_cnpj;

	@ManyToOne
	@JoinColumn(name = "id_endereco", nullable = false) 
	private Endereco endereço;
	
	@ManyToOne
	@JoinColumn(name = "id_produto", nullable = false) 
	private Produto produto;
 


}
