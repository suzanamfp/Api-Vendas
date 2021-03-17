package com.br.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.demo.model.entity.Funcionario;
import com.br.demo.service.impl.FuncionarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/funcionario", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "API REST Funcionario")
@CrossOrigin(origins = "*")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@PostMapping
	@ApiOperation(value = "Salva uma funcionario")
	public ResponseEntity<Funcionario> create(@RequestBody Funcionario funcionario) {
		return ResponseEntity.of(Optional.of(funcionarioService.novo(funcionario)));
	}

	@GetMapping(value = "/funcionario")
	@ApiOperation(value = "Retorna uma lista de funcionarios")
	public ResponseEntity<List<Funcionario>> findAll() {
		List<Funcionario> listaFuncionario = (List<Funcionario>) funcionarioService.allEmployee(); // Employee = funcionario
		return new ResponseEntity<List<Funcionario>>(listaFuncionario, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Retorna um único funcionario")
	public ResponseEntity<Funcionario> findById(@PathVariable(value = "id") Long id) {
		return funcionarioService.funcionarioPorId(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(value = "/{id}")
	@ApiOperation(value = "Atualiza os registros de funcionario")
	public ResponseEntity<Funcionario> update(@PathVariable("id") Long id, @Valid @RequestBody Funcionario funcionario) {
		return ResponseEntity.ok(funcionarioService.alterarFuncionario(funcionario));
	}

	@DeleteMapping
	@ApiOperation(value = "Exclui um registro de funcionario")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		return funcionarioService.funcionarioPorId(id).map(record -> {
			funcionarioService.excluir(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());

	}

}
