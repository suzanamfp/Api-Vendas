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

import com.br.demo.model.entity.Endereco;
import com.br.demo.service.impl.EnderecoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/endereco", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value="API REST Endereco")
@CrossOrigin(origins="*")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	
	@PostMapping
	@ApiOperation(value="Salva um endereco")
	public ResponseEntity<Endereco> create (@RequestBody Endereco endereco) {
		return ResponseEntity.of(Optional.of(enderecoService.novo(endereco)));
	}

	
	@GetMapping(value ="/endereco")
	@ApiOperation(value="Retorna uma lista de enderecos")
	public ResponseEntity<List<Endereco>> findAll(){
		List<Endereco> listaEndereco = (List<Endereco>) enderecoService.allAdress();
		return new ResponseEntity<List<Endereco>>(listaEndereco, HttpStatus.OK);
	}


	@GetMapping(value ="/{id}")
	@ApiOperation(value="Retorna um único endereco")
	public ResponseEntity<Endereco> findById(@PathVariable (value = "id") Long id){
		return enderecoService.enderecoPorId(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	
	@PutMapping(value ="/{id}")
	@ApiOperation(value="Atualiza os registros de enderecos")
	public ResponseEntity<Endereco> update(@PathVariable("id") Long id, @Valid @RequestBody Endereco endereco){
		return  ResponseEntity.ok(enderecoService.alterarEndereco(endereco));	
	}
	
	@DeleteMapping
	@ApiOperation(value="Exclui um registro de endereco")
	public ResponseEntity<?> delete(@PathVariable (value="id") Long id){
		return enderecoService.enderecoPorId(id)
				.map(record -> {
					enderecoService.excluir(id);
					return ResponseEntity.ok().build();
				}) .orElse(ResponseEntity.notFound().build());
		
		
		
	}
	

}
