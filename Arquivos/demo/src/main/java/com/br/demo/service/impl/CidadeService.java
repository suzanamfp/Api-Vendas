package com.br.demo.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.demo.model.entity.Cidade;
import com.br.demo.repositorys.CidadeRepository;
import com.br.demo.service.inter.ICidadeService;

@Service
public class CidadeService implements ICidadeService{
	
	@Autowired
	private CidadeRepository cidadeRepository;


	public Cidade novo(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}

	public Optional<Cidade> cidadePorId(Long id) {
		return cidadeRepository.findById(id);
	}

	public List<Cidade> allCity() {
		return (List<Cidade>)cidadeRepository.findAll();
	}

	
	public Cidade alterarCidade(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}

	public void excluir(Long id) {
		cidadeRepository.deleteById(id);
		
	}

	

}
