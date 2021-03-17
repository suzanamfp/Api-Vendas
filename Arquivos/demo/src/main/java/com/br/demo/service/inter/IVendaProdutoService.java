package com.br.demo.service.inter;

import java.util.List;
import java.util.Optional;

import com.br.demo.model.entity.VendaProduto;

public interface IVendaProdutoService{

	public VendaProduto novo(VendaProduto vendaProduto);
	
	public Optional<VendaProduto> vendaProdutoPorId(Long id);
	
	public List<VendaProduto> allSellProduct() ;
	
	public VendaProduto alterarVendaProduto(VendaProduto vendaProduto);
	
	public void excluir(Long id);
	
}
