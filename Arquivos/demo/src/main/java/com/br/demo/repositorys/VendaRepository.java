package com.br.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.demo.model.entity.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
