package com.br.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.br.demo.model.entity.Venda;

public interface IVendaService {
	
	public Venda novo(Venda venda);
	
	public Optional<Venda> vendaPorId(Long id);
	
	public List<Venda> allSell() ;
	
	public Venda alterarVenda(Venda venda);
	
	public void excluir(Long id);
	
	

}
