package com.br.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.demo.model.entity.Venda;
import com.br.demo.repositorys.VendaRepository;

@Service
public class VendaService implements IVendaService{
	
	@Autowired
	private VendaRepository vendaRepository;


	public Venda novo(Venda venda) {
		return vendaRepository.save(venda);
	}

	public Optional<Venda> vendaPorId(Long id) {
		return vendaRepository.findById(id);
	}

	public List<Venda> allSell() {
		return (List<Venda>)vendaRepository.findAll();
	}

	
	public Venda alterarVenda(Venda venda) {
		return vendaRepository.save(venda);
	}

	public void excluir(Long id) {
		vendaRepository.deleteById(id);
		
	}

}
