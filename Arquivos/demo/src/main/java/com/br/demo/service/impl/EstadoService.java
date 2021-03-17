package com.br.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.demo.model.entity.Estado;
import com.br.demo.repositorys.EstadoRepository;
import com.br.demo.service.inter.IEstadoService;

@Service
public class EstadoService implements IEstadoService{

	@Autowired
	private EstadoRepository estadoRepository;
	

	@Override
	public Estado novo(Estado estado) {
		return estadoRepository.save(estado);
	}

	@Override
	public List<Estado> estados() {
		return (List<Estado>) estadoRepository.findAll();
	}

	@Override
	public Optional<Estado> estadoPorId(Long id) {
		return estadoRepository.findById(id);
	}

	@Override
	public Estado alterar(Estado estado) {
		return estadoRepository.save(estado);
	}

	@Override
	public void excluir(Long id) {
		estadoRepository.deleteById(id);
	}

	
}
