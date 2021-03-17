package com.br.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.demo.model.entity.Compra;
import com.br.demo.repositorys.CompraRepository;
import com.br.demo.service.inter.ICompraService;

@Service
public class CompraService implements ICompraService{
	
	@Autowired
	private CompraRepository compraRepository;
	
	public Compra novo(Compra compra) {
		return compraRepository.save(compra);
	}

	public Optional<Compra> compraPorId(Long id) {
		return compraRepository.findById(id);
	}

	public List<Compra> allPurchase() {
		return (List<Compra>)compraRepository.findAll();
	}

	public Compra alterarCompra(Compra compra) {
		return compraRepository.save(compra);
	}

	public void excluir(Long id) {
		compraRepository.deleteById(id);
		
	}


}
