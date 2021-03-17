package com.br.demo.service.inter;

import java.util.List;
import java.util.Optional;

import com.br.demo.model.entity.LogradouroBairro;

public interface ILogradouroBairroService {

	
	public LogradouroBairro novo(LogradouroBairro logradouroBairro);
	
	public List<LogradouroBairro> allLograBairro();
	
	public Optional<LogradouroBairro> logradouroBairroPorId(Long id);
	
	public LogradouroBairro alterarLograBairro(LogradouroBairro logradouroBairro);
	
	public void excluir(Long id);
}
