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



@Table (name = "venda_produto")
@Entity
@Data
public class VendaProduto {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_venda_produto")
	private long id;
	
	@Column (name = "quant_produto")
	private int quantProduto;
	
	@ManyToOne
	@JoinColumn(name = "id_venda", nullable = false)
	private Venda venda;
	
	@ManyToOne
	@JoinColumn(name = "id_produto", nullable = false)
	private Produto produto;
	
}
