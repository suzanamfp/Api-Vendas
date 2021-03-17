package com.br.demo.service.inter;

import java.util.List;
import java.util.Optional;

import com.br.demo.model.entity.Fornecedor;

public interface IFornecedorService {
	
	public Fornecedor novo(Fornecedor fornecedor);
	
	public Optional<Fornecedor> fornecedorPorId(Long id);
	
	public List<Fornecedor> allProvide() ;
	
	public Fornecedor alterarFornecedor(Fornecedor fornecedor);
	
	public void excluir(Long id);


}
