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

import com.br.demo.model.entity.Cidade;
import com.br.demo.service.impl.CidadeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/cidade", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value="API REST Cidade")
@CrossOrigin(origins="*")
public class CidadeController {
	
	@Autowired
	private CidadeService cidadeService;
	
	
	@PostMapping
	@ApiOperation(value="Salva uma cidade")
	public ResponseEntity<Cidade> create (@RequestBody Cidade cidade) {
		return ResponseEntity.of(Optional.of(cidadeService.novo(cidade)));
	}


	@GetMapping(value ="/cidades")
	@ApiOperation(value="Retorna uma lista de cidades")
	public ResponseEntity<List<Cidade>> findAll(){
		List<Cidade> listaCidade = (List<Cidade>) cidadeService.allCity();
		return new ResponseEntity<List<Cidade>>(listaCidade, HttpStatus.OK);
	}


	@GetMapping(value ="/{id}")
	@ApiOperation(value="Retorna uma única cidade")
	public ResponseEntity<Cidade> findById(@PathVariable (value = "id") Long id){
		return cidadeService.cidadePorId(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	
	@PutMapping(value ="/{id}")
	@ApiOperation(value="Atualiza os registros de cidades")
	public ResponseEntity<Cidade> update(@PathVariable("id") Long id, @Valid @RequestBody Cidade cidade){
		return  ResponseEntity.ok(cidadeService.alterarCidade(cidade));	
	}
	
	@DeleteMapping
	@ApiOperation(value="Exclui um registro de cidade")
	public ResponseEntity<?> delete(@PathVariable (value="id") Long id){
		return cidadeService.cidadePorId(id)
				.map(record -> {
					cidadeService.excluir(id);
					return ResponseEntity.ok().build();
				}) .orElse(ResponseEntity.notFound().build());
		
		
		
	}
}
