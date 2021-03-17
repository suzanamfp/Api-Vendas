package com.br.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.demo.model.entity.Bairro;
import com.br.demo.repositorys.BairroRepository;
import com.br.demo.service.inter.IBairroService;

@Service
public class BairroService implements IBairroService{
	
	@Autowired
	private BairroRepository bairroRepository;
	
	public Bairro novo(Bairro bairro) {
		return bairroRepository.save(bairro);	
	}
	
	public Optional<Bairro> bairroPorId(Long id){
		return bairroRepository.findById(id);	
	}
	
	public List<Bairro> allDistrict(){
		return (List<Bairro>)bairroRepository.findAll();
		
	}
	
	public Bairro alterarBairro(Bairro bairro) {
		return bairroRepository.save(bairro);
		
	}
	
	public void excluir(Long id) {
		bairroRepository.deleteById(id);
		
	}


	
}
