package com.br.demo.service.inter;

import java.util.List;
import java.util.Optional;

import com.br.demo.model.entity.Funcionario;

public interface IFuncionarioService {
	
	public Funcionario novo(Funcionario funcionario);
	
	public Optional<Funcionario> funcionarioPorId(Long id);
	
	public List<Funcionario> allEmployee();
	
	public Funcionario alterarFuncionario(Funcionario funcionario);
	
	public void excluir(Long id);

}
