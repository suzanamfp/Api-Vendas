package com.br.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.demo.model.entity.Funcionario;
import com.br.demo.repositorys.FuncionarioRepository;
import com.br.demo.service.inter.IFuncionarioService;

@Service
public class FuncionarioService implements IFuncionarioService{
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario novo(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public Optional<Funcionario> funcionarioPorId(Long id) {
		return funcionarioRepository.findById(id);
	}

	public List<Funcionario> allEmployee() {
		return (List<Funcionario>)funcionarioRepository.findAll();
	}

	public Funcionario alterarFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public void excluir(Long id) {
		funcionarioRepository.deleteById(id);
	}
}
