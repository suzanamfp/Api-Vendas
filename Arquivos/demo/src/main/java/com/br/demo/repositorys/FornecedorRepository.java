package com.br.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.demo.model.entity.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{

}
