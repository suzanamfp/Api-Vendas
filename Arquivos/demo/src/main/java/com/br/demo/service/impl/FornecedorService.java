package com.br.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.demo.model.entity.Fornecedor;
import com.br.demo.repositorys.FornecedorRepository;

@Service
public class FornecedorService {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;


	public Fornecedor novo(Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);
	}

	public Optional<Fornecedor> fornecedorPorId(Long id) {
		return fornecedorRepository.findById(id);
	}

	public List<Fornecedor> allProvider() {
		return (List<Fornecedor>)fornecedorRepository.findAll();
	}

	
	public Fornecedor alterarFornecedor(Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);
	}

	public void excluir(Long id) {
		fornecedorRepository.deleteById(id);
		
	}

}
