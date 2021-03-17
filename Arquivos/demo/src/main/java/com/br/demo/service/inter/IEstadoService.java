package com.br.demo.service.inter;

import java.util.List;
import java.util.Optional;

import com.br.demo.model.entity.Estado;

public interface IEstadoService {

	public Estado novo(Estado estado);
	
	public List<Estado> estados();
	
	public Optional<Estado> estadoPorId(Long id);
	
	public Estado alterar(Estado estado);
	
	public void excluir(Long id);
	
}
