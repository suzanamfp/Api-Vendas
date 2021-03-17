package com.br.demo.service.inter;

import java.util.List;
import java.util.Optional;

import com.br.demo.model.entity.Cidade;

	public interface ICidadeService {
		
		public Cidade novo(Cidade cidade);
		
		public Optional<Cidade> cidadePorId(Long id);
		
		public List<Cidade> allCity() ;
		
		public Cidade alterarCidade(Cidade cidade);
		
		public void excluir(Long id);
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
