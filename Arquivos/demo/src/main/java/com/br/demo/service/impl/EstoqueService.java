package com.br.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.demo.model.entity.Estoque;
import com.br.demo.repositorys.EstoqueRepository;
import com.br.demo.service.inter.IEstoqueService;

@Service
public class EstoqueService implements IEstoqueService{

	@Autowired
	private EstoqueRepository estoqueRepository;
	

	public Estoque novo(Estoque estoque) {
		return estoqueRepository.save(estoque);
	}

	public List<Estoque> allInventory() {
		return (List<Estoque>) estoqueRepository.findAll();
	}

	public Optional<Estoque> estoquePorId(Long id) {
		return estoqueRepository.findById(id);
	}

	public Estoque alterarEstoque(Estoque estoque) {
		return estoqueRepository.save(estoque);
	}

	public void excluir(Long id) {
		estoqueRepository.deleteById(id);
	}
}
