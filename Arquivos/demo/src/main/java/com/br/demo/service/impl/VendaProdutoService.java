package com.br.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.demo.model.entity.VendaProduto;
import com.br.demo.repositorys.VendaProdutoRepository;
import com.br.demo.service.inter.IVendaProdutoService;

@Service
public class VendaProdutoService implements IVendaProdutoService {
	
	@Autowired
	private VendaProdutoRepository vendaProdutoRepository;


	public VendaProduto novo(VendaProduto vendaProduto) {
		return vendaProdutoRepository.save(vendaProduto);
	}

	public Optional<VendaProduto> vendaProdutoPorId(Long id) {
		return vendaProdutoRepository.findById(id);
	}

	public List<VendaProduto> allSellProduct() {
		return (List<VendaProduto>)vendaProdutoRepository.findAll();
	}

	
	public VendaProduto alterarVendaProduto(VendaProduto vendaProduto) {
		return vendaProdutoRepository.save(vendaProduto);
	}

	public void excluir(Long id) {
		vendaProdutoRepository.deleteById(id);
		
	}

}
