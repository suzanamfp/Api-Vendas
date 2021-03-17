package com.br.demo.service.inter;

import java.util.List;
import java.util.Optional;

import com.br.demo.model.entity.Produto;

public interface IProdutoService {
	
	public Produto novo(Produto produto);
	
	public Optional<Produto> produtoPorId(Long id);
	
	public List<Produto> allProduct() ;
	
	public Produto alterarProduto(Produto produto);
	
	public void excluir(Long id);

}
