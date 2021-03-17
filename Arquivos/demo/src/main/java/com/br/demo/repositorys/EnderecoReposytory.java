package com.br.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.demo.model.entity.Endereco;

@Repository
public interface EnderecoReposytory extends JpaRepository <Endereco, Long> {
	
	
	

}
