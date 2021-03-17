package com.br.demo.service.inter;

import java.util.List;
import java.util.Optional;

import com.br.demo.model.entity.Estoque;

public interface IEstoqueService {
	
	public Estoque novo(Estoque estoque);
	
	public List<Estoque> allInventory();
	
	public Optional<Estoque> estoquePorId(Long id);
	
	public Estoque alterarEstoque(Estoque estoque);
	
	public void excluir(Long id);

}
