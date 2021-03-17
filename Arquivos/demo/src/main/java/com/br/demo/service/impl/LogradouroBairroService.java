package com.br.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.demo.model.entity.LogradouroBairro;
import com.br.demo.repositorys.LogradouroBairroRepository;
import com.br.demo.service.inter.ILogradouroBairroService;

@Service
public class LogradouroBairroService implements ILogradouroBairroService {
	
	@Autowired
	private LogradouroBairroRepository logradouroBairroRepository;
	
	
	@Override
	public LogradouroBairro novo(LogradouroBairro logradouroBairro) {
		return logradouroBairroRepository.save(logradouroBairro);
	}

	@Override
	public List<LogradouroBairro> allLograBairro() {
		return (List<LogradouroBairro>) logradouroBairroRepository.findAll();
	}

	@Override
	public Optional<LogradouroBairro> logradouroBairroPorId(Long id) {
		return logradouroBairroRepository.findById(id);
	}

	@Override
	public LogradouroBairro alterarLograBairro(LogradouroBairro logradouroBairro) {
		return logradouroBairroRepository.save(logradouroBairro);
	}

	@Override
	public void excluir(Long id) {
		logradouroBairroRepository.deleteById(id);
	}

	
}


