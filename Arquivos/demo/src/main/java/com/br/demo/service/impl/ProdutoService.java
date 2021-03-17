package com.br.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.demo.model.entity.Produto;
import com.br.demo.repositorys.ProdutoRepository;
import com.br.demo.service.inter.IProdutoService;

@Service
public class ProdutoService implements IProdutoService{
		
		@Autowired
		private ProdutoRepository produtoRepository;


		public Produto novo(Produto produto) {
			return produtoRepository.save(produto);
		}

		public Optional<Produto> produtoPorId(Long id) {
			return produtoRepository.findById(id);
		}

		public List<Produto> allProduct() {
			return (List<Produto>)produtoRepository.findAll();
		}

		
		public Produto alterarProduto(Produto produto) {
			return produtoRepository.save(produto);
		}

		public void excluir(Long id) {
			produtoRepository.deleteById(id);
			
		}

}
