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

import com.br.demo.model.entity.Compra;
import com.br.demo.service.impl.CompraService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/compra", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value="API REST Compra")
@CrossOrigin(origins="*")
public class CompraContoller {
	

	@Autowired
	private CompraService compraService;
	
	
	@PostMapping
	@ApiOperation(value="Salva uma compra")
	public ResponseEntity<Compra> create (@RequestBody Compra compra) {
		return ResponseEntity.of(Optional.of(compraService.novo(compra)));
	}

	
	@GetMapping(value ="/compra")
	@ApiOperation(value="Retorna uma lista de compras")
	public ResponseEntity<List<Compra>> findAll(){
		List<Compra> listaCompra= (List<Compra>) compraService.allPurchase(); //Purchase = comprar
		return new ResponseEntity<List<Compra>>(listaCompra, HttpStatus.OK);
	}


	@GetMapping(value ="/{id}")
	@ApiOperation(value="Retorna uma única compra")
	public ResponseEntity<Compra> findById(@PathVariable (value = "id") Long id){
		return compraService.compraPorId(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	
	@PutMapping(value ="/{id}")
	@ApiOperation(value="Atualiza os registros de compra")
	public ResponseEntity<Compra> update(@PathVariable("id") Long id, @Valid @RequestBody Compra compra){
		return  ResponseEntity.ok(compraService.alterarCompra(compra));	
	}
	
	@DeleteMapping
	@ApiOperation(value="Exclui um registro de compra")
	public ResponseEntity<?> delete(@PathVariable (value="id") Long id){
		return compraService.compraPorId(id)
				.map(record -> {
					compraService.excluir(id);
					return ResponseEntity.ok().build();
				}) .orElse(ResponseEntity.notFound().build());
		
	}
}
