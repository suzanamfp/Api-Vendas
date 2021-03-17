package com.br.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Table (name = "estado")
@AllArgsConstructor //cria construtor com argumento
@NoArgsConstructor //cria construtor sem argumento
@Entity //a classe será automaticamente mapeada à tabela com o mesmo nome
@Data //cria automaticamente os métodos toString, equals, hashCode, getters e setters

public class Estado {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado")
	private Long id;
	
	@Column (name = "nome_estado")
	private String nome;
	
	@Column (name = "uf", unique = true)
	private String uf;

	
	

	

}
