package com.br.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import com.br.demo.model.entity.Cidade;

	public interface CidadeRepository extends JpaRepository <Cidade, Long>{
	}
