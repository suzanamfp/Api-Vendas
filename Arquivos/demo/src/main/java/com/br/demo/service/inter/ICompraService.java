package com.br.demo.service.inter;

import java.util.List;
import java.util.Optional;

import com.br.demo.model.entity.Compra;

public interface ICompraService {
	
	public Compra novo(Compra compra);
	
	public Optional<Compra> compraPorId(Long id);
	
	public List<Compra> allPurchase();
	
	public Compra alterarCompra(Compra compra);
	
	public void excluir(Long id);
	

}
