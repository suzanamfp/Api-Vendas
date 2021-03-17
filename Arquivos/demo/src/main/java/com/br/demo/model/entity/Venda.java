package com.br.demo.model.entity;

	
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;



@Data
@Table (name = "venda")
@Entity

public class Venda {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	@Column(name = "id_venda")
	private long id;
	
	@OneToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_funcionario", nullable = false)
	private Funcionario funcionario;
	
	@Column (name = "valor_venda")
	private long valor;
	
	@Column (name = "total_venda")
	private float total;
		

}

