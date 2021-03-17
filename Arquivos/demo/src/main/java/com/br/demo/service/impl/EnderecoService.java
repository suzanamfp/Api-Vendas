package com.br.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.demo.model.entity.Endereco;
import com.br.demo.repositorys.EnderecoRepository;
import com.br.demo.service.inter.IEnderecoService;

@Service
public class EnderecoService implements IEnderecoService{
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	
	public Endereco novo(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	
	public List<Endereco> allAdress() {
		return (List<Endereco>) enderecoRepository.findAll();
	}

	
	public Optional<Endereco> enderecoPorId(Long id) {
		return enderecoRepository.findById(id);
	}

	
	public Endereco alterarEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	
	public void excluir(Long id) {
		enderecoRepository.deleteById(id);
	}


}
