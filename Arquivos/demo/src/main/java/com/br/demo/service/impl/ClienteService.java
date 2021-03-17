package com.br.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.demo.model.entity.Cliente;
import com.br.demo.repositorys.ClienteRepository;
import com.br.demo.service.inter.IClienteService;

@Service
public class ClienteService implements IClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;


	public Cliente novo(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Optional<Cliente> clientePorId(Long id) {
		return clienteRepository.findById(id);
	}

	public List<Cliente> allCliente() {
		return (List<Cliente>)clienteRepository.findAll();
	}

	
	public Cliente alterarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public void excluir(Long id) {
		clienteRepository.deleteById(id);
		
	}

}
