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

import com.br.demo.model.entity.Venda;
import com.br.demo.service.impl.VendaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/venda", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value="API REST Venda")
@CrossOrigin(origins="*")
public class VendaController {
	
	@Autowired
	private VendaService vendaService;
	
	
	@PostMapping
	@ApiOperation(value="Salva uma venda")
	public ResponseEntity<Venda> create (@RequestBody Venda venda) {
		return ResponseEntity.of(Optional.of(vendaService.novo(venda)));
	}

	
	@GetMapping(value ="/venda")
	@ApiOperation(value="Retorna uma lista de vendas")
	public ResponseEntity<List<Venda>> findAll(){
		List<Venda> listaVenda= (List<Venda>) vendaService.allSell(); //Sell=Vender
		return new ResponseEntity<List<Venda>>(listaVenda, HttpStatus.OK);
	}


	@GetMapping(value ="/{id}")
	@ApiOperation(value="Retorna uma única venda")
	public ResponseEntity<Venda> findById(@PathVariable (value = "id") Long id){
		return vendaService.vendaPorId(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	
	@PutMapping(value ="/{id}")
	@ApiOperation(value="Atualiza os registros de venda")
	public ResponseEntity<Venda> update(@PathVariable("id") Long id, @Valid @RequestBody Venda venda){
		return  ResponseEntity.ok(vendaService.alterarVenda(venda));	
	}
	
	@DeleteMapping
	@ApiOperation(value="Exclui um registro de venda")
	public ResponseEntity<?> delete(@PathVariable (value="id") Long id){
		return vendaService.vendaPorId(id)
				.map(record -> {
					vendaService.excluir(id);
					return ResponseEntity.ok().build();
				}) .orElse(ResponseEntity.notFound().build());
		
		
		
	}

}
