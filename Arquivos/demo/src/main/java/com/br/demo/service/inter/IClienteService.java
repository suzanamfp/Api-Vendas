package com.br.demo.service.inter;

import java.util.List;
import java.util.Optional;

import com.br.demo.model.entity.Cliente;

public interface IClienteService {

	public Cliente novo(Cliente cliente);
	
	public Optional<Cliente> clientePorId(Long id);
	
	public List<Cliente> allCliente() ;
	
	public Cliente alterarCliente(Cliente cliente);
	
	public void excluir(Long id);
	
}
