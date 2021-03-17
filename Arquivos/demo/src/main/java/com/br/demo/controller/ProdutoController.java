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

import com.br.demo.model.entity.Produto;
import com.br.demo.service.impl.ProdutoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/produto", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value="API REST Produto")
@CrossOrigin(origins="*")
public class ProdutoController {


	@Autowired
	private ProdutoService produtoService;
	
	
	@PostMapping
	@ApiOperation(value="Salva um produto")
	public ResponseEntity<Produto> create (@RequestBody Produto produto) {
		return ResponseEntity.of(Optional.of(produtoService.novo(produto)));
	}

	
	@GetMapping(value ="/produto")
	@ApiOperation(value="Retorna uma lista de produtos")
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> listaProduto = (List<Produto>) produtoService.allProduct();
		return new ResponseEntity<List<Produto>>(listaProduto, HttpStatus.OK);
	}


	@GetMapping(value ="/{id}")
	@ApiOperation(value="Retorna um único produto")
	public ResponseEntity<Produto> findById(@PathVariable (value = "id") Long id){
		return produtoService.produtoPorId(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	
	@PutMapping(value ="/{id}")
	@ApiOperation(value="Atualiza os registros de produto")
	public ResponseEntity<Produto> update(@PathVariable("id") Long id, @Valid @RequestBody Produto produto){
		return  ResponseEntity.ok(produtoService.alterarProduto(produto));	
	}
	
	@DeleteMapping
	@ApiOperation(value="Exclui um registro de produto")
	public ResponseEntity<?> delete(@PathVariable (value="id") Long id){
		return produtoService.produtoPorId(id)
				.map(record -> {
					produtoService.excluir(id);
					return ResponseEntity.ok().build();
				}) .orElse(ResponseEntity.notFound().build());
		
		
		
	}
	
}
