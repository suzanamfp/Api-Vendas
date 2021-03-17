package com.br.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.demo.model.entity.Logradouro;

@Repository
public interface LogradouroRepository extends JpaRepository<Logradouro, Long> {

}


