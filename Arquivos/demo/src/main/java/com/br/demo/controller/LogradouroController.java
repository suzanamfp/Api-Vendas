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

import com.br.demo.model.entity.Logradouro;
import com.br.demo.service.impl.LogradouroService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/logradouro", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value="API REST Logradouro")
@CrossOrigin(origins="*")
public class LogradouroController {
	
	@Autowired 
	private LogradouroService logradouroService;
	
	
	@PostMapping
	@ApiOperation(value="Salva um logradouro")
	public ResponseEntity<Logradouro> create (@RequestBody Logradouro logradouro) {
		return ResponseEntity.of(Optional.of(logradouroService.novo(logradouro)));
	}
	
	@GetMapping(value ="/logradouro")
	@ApiOperation(value="Retorna uma lista de logradouros")
	public ResponseEntity<List<Logradouro>> findAll(){
		List<Logradouro> listaLogradouro = (List<Logradouro>) logradouroService.allLogradouro();
		return new ResponseEntity<List<Logradouro>>(listaLogradouro, HttpStatus.OK);
	}
	
	@GetMapping(value ="/{id}")
	@ApiOperation(value="Retorna um único logradouro")
	public ResponseEntity<Logradouro> findById(@PathVariable (value = "id") Long id){
		return logradouroService.logradouroPorId(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	
	@PutMapping(value ="/{id}")
	@ApiOperation(value="Atualiza os registros de logradouro")
	public ResponseEntity<Logradouro> update(@PathVariable("id") Long id, @Valid @RequestBody Logradouro logradouro){
		return  ResponseEntity.ok(logradouroService.alterarLogradouro(logradouro));	
	}
	
	
	@DeleteMapping
	@ApiOperation(value="Exclui um registro de logradouro")
	public ResponseEntity<?> delete(@PathVariable (value="id") Long id){
		return logradouroService.logradouroPorId(id)
				.map(record -> {
					logradouroService.excluir(id);
					return ResponseEntity.ok().build();
				}) .orElse(ResponseEntity.notFound().build());
		
		
		
	}
	
	
}
