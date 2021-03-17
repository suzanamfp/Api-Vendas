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

import com.br.demo.model.entity.Cliente;
import com.br.demo.service.impl.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value="API REST Cliente")
@CrossOrigin(origins="*")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@PostMapping
	@ApiOperation(value="Salva uma cliente")
	public ResponseEntity<Cliente> create (@RequestBody Cliente cliente) {
		return ResponseEntity.of(Optional.of(clienteService.novo(cliente)));
	}

	
	@GetMapping(value ="/cliente")
	@ApiOperation(value="Retorna uma lista de cliente")
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> listaCliente= (List<Cliente>) clienteService.allCliente(); 
		return new ResponseEntity<List<Cliente>>(listaCliente, HttpStatus.OK);
	}


	@GetMapping(value ="/{id}")
	@ApiOperation(value="Retorna uma única cliente")
	public ResponseEntity<Cliente> findById(@PathVariable (value = "id") Long id){
		return clienteService.clientePorId(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	
	@PutMapping(value ="/{id}")
	@ApiOperation(value="Atualiza os registros de cliente")
	public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @Valid @RequestBody Cliente cliente){
		return  ResponseEntity.ok(clienteService.alterarCliente(cliente));	
	}
	
	@DeleteMapping
	@ApiOperation(value="Exclui um registro de cliente")
	public ResponseEntity<?> delete(@PathVariable (value="id") Long id){
		return clienteService.clientePorId(id)
				.map(record -> {
					clienteService.excluir(id);
					return ResponseEntity.ok().build();
				}) .orElse(ResponseEntity.notFound().build());
		
		
		
	}

}
