package com.br.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.demo.model.entity.Logradouro;
import com.br.demo.repositorys.LogradouroRepository;
import com.br.demo.service.inter.ILogradouroService;

@Service
public class LogradouroService implements ILogradouroService {

	
	@Autowired
	private LogradouroRepository logradouroRepository;
	
	
	public Logradouro novo(Logradouro logradouro) {
		return logradouroRepository.save(logradouro);	
	}
	
	public Optional<Logradouro> logradouroPorId(Long id){
		return logradouroRepository.findById(id);	
	}
	
	public List<Logradouro> allLogradouro(){
		return (List<Logradouro>)logradouroRepository.findAll();
	}
	
	public Logradouro alterarLogradouro(Logradouro logradouro) {
		return logradouroRepository.save(logradouro);	
	}
	
	public void excluir(Long id) {
		logradouroRepository.deleteById(id);	
	}

	

}
