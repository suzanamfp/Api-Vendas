package com.br.demo.service.inter;

import java.util.List;
import java.util.Optional;

import com.br.demo.model.entity.Bairro;


public interface IBairroService {
	
	
	public Bairro novo(Bairro bairro);
	
	public Optional<Bairro> bairroPorId(Long id);
	
	public List<Bairro> allDistrict() ;
	
	public Bairro alterarBairro(Bairro bairro);
	
	public void excluir(Long id);

}
