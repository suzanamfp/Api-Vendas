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

import com.br.demo.model.entity.Estoque;
import com.br.demo.service.impl.EstoqueService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/estoque", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value="API REST Estoque")
@CrossOrigin(origins="*")
public class EstoqueController {
	
	@Autowired 
	private EstoqueService estoqueService;

	//MÉTODOS CRUD

	@PostMapping 
	public ResponseEntity<Estoque> create (@RequestBody Estoque estoque) {
		return ResponseEntity.of(Optional.of(estoqueService.novo(estoque)));
	}

	@GetMapping(value ="/estoque")
	public ResponseEntity<List<Estoque>> findAll(){//O método findAll é direto ao ponto: utiliza o método findAll da interface JpaRepository que faz um select * from estado.
		List<Estoque> listaEstoque = (List<Estoque>) estoqueService.allInventory(); //Inventory = estoque
		return new ResponseEntity<List<Estoque>>(listaEstoque, HttpStatus.OK); 
	}

	@GetMapping(value ="/{id}")
	public ResponseEntity <Estoque> findById(@PathVariable (value = "id") Long id) { //Esse método retorna apenas o id que estamos procurando dentro de Estado
		return estoqueService.estoquePorId(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping (value="/{id}")
	public ResponseEntity<Estoque> update (@PathVariable("id") Long id, @Valid @RequestBody Estoque estoque) { //Atualiza os dados que foram inseridos atraves do ID
		return  ResponseEntity.ok(estoqueService.alterarEstoque(estoque));
	}

	@DeleteMapping(path ="/{id}")
	public ResponseEntity <?> delete(@PathVariable Long id){ //remove um estado pelo ID
		return estoqueService.estoquePorId(id)
				.map(record -> {
					estoqueService.excluir(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}


}
