package com.br.demo.service.inter;

import java.util.List;
import java.util.Optional;

import com.br.demo.model.entity.Endereco;


public interface IEnderecoService {
	
	public Endereco novo(Endereco endereco);
	
	public List<Endereco> allAdress();
	
	public Optional<Endereco> enderecoPorId(Long id);
	
	public Endereco alterarEndereco(Endereco endereco);
	
	public void excluir(Long id);

}
