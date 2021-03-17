package com.br.demo.service.inter;

import java.util.List;
import java.util.Optional;

import com.br.demo.model.entity.Logradouro;

public interface ILogradouroService {
	
	public Logradouro novo(Logradouro logradouro);
	
	public Optional<Logradouro> logradouroPorId(Long id);
	
	public List<Logradouro> allLogradouro() ;
	
	public Logradouro alterarLogradouro(Logradouro logradouro);
	
	public void excluir(Long id);

}
