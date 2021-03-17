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

import com.br.demo.model.entity.VendaProduto;
import com.br.demo.service.impl.VendaProdutoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/vendaProduto", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value="API REST VendaProduto")
@CrossOrigin(origins="*")
public class VendaProdutoController {
	
	@Autowired
	private VendaProdutoService vendaProdutoService;
	
	
	@PostMapping
	@ApiOperation(value="Salva uma venda com produtos")
	public ResponseEntity<VendaProduto> create (@RequestBody VendaProduto vendaProduto) {
		return ResponseEntity.of(Optional.of(vendaProdutoService.novo(vendaProduto)));
	}

	
	@GetMapping(value ="/vendaProduto")
	@ApiOperation(value="Retorna uma lista de vendas com produtos")
	public ResponseEntity<List<VendaProduto>> findAll(){
		List<VendaProduto> listaVendaProduto= (List<VendaProduto>) vendaProdutoService.allSellProduct(); //Sell=Vender
		return new ResponseEntity<List<VendaProduto>>(listaVendaProduto, HttpStatus.OK);
	}


	@GetMapping(value ="/{id}")
	@ApiOperation(value="Retorna uma única venda com produto")
	public ResponseEntity<VendaProduto> findById(@PathVariable (value = "id") Long id){
		return vendaProdutoService.vendaProdutoPorId(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	
	@PutMapping(value ="/{id}")
	@ApiOperation(value="Atualiza os registros de venda com produtos")
	public ResponseEntity<VendaProduto> update(@PathVariable("id") Long id, @Valid @RequestBody VendaProduto vendaProduto){
		return  ResponseEntity.ok(vendaProdutoService.alterarVendaProduto(vendaProduto));	
	}
	
	@DeleteMapping
	@ApiOperation(value="Exclui um registro de venda com produtos")
	public ResponseEntity<?> delete(@PathVariable (value="id") Long id){
		return vendaProdutoService.vendaProdutoPorId(id)
				.map(record -> {
					vendaProdutoService.excluir(id);
					return ResponseEntity.ok().build();
				}) .orElse(ResponseEntity.notFound().build());
		
		
		
	}

}
