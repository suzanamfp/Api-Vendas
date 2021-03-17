package com.br.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Table (name = "produto")
@Entity
@Data
public class Produto {
	 
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long id;
	
	@Column (name = "nome_produto")
	private String nome;
	
	@Column (name = "tipo_produto")
	private String tipo;
	
	@Column (name = "valor_venda")
	private Long valor;
}
