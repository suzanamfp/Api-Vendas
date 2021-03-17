package com.br.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.demo.model.entity.Estado;


@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
