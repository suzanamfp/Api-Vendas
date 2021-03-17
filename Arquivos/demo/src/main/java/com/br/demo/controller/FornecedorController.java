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

import com.br.demo.model.entity.Fornecedor;
import com.br.demo.service.impl.FornecedorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/fornecedor", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value="API REST Fornecedor")
@CrossOrigin(origins="*")
public class FornecedorController {
	
	@Autowired
	private FornecedorService fornecedorService;
	
	
	@PostMapping
	@ApiOperation(value="Salva uma fornecedores")
	public ResponseEntity<Fornecedor> create (@RequestBody Fornecedor fornecedor) {
		return ResponseEntity.of(Optional.of(fornecedorService.novo(fornecedor)));
	}

	
	@GetMapping(value ="/fornecedor")
	@ApiOperation(value="Retorna uma lista de fornecedores")
	public ResponseEntity<List<Fornecedor>> findAll(){
		List<Fornecedor> listaFornecedor= (List<Fornecedor>) fornecedorService.allProvider(); //Provider = Fornecedor
		return new ResponseEntity<List<Fornecedor>>(listaFornecedor, HttpStatus.OK);
	}


	@GetMapping(value ="/{id}")
	@ApiOperation(value="Retorna um únic fornecedor")
	public ResponseEntity<Fornecedor> findById(@PathVariable (value = "id") Long id){
		return fornecedorService.fornecedorPorId(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	
	@PutMapping(value ="/{id}")
	@ApiOperation(value="Atualiza os registros de fornecedor")
	public ResponseEntity<Fornecedor> update(@PathVariable("id") Long id, @Valid @RequestBody Fornecedor fornecedor){
		return  ResponseEntity.ok(fornecedorService.alterarFornecedor(fornecedor));	
	}
	
	@DeleteMapping
	@ApiOperation(value="Exclui um registro de fornecedor")
	public ResponseEntity<?> delete(@PathVariable (value="id") Long id){
		return fornecedorService.fornecedorPorId(id)
				.map(record -> {
					fornecedorService.excluir(id);
					return ResponseEntity.ok().build();
				}) .orElse(ResponseEntity.notFound().build());
		
		
		
	}


}
