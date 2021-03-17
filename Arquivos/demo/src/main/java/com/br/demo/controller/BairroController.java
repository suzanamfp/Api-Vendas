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

import com.br.demo.model.entity.Bairro;
import com.br.demo.service.impl.BairroService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/bairro", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value="API REST Bairro")
@CrossOrigin(origins="*")
public class BairroController {
	
	@Autowired
	private BairroService bairroService;
	
	
	@PostMapping
	@ApiOperation(value="Salva um bairro")
	public ResponseEntity<Bairro> create (@RequestBody Bairro bairro) {
		return ResponseEntity.of(Optional.of(bairroService.novo(bairro)));
	}

	
	@GetMapping(value ="/bairro")
	@ApiOperation(value="Retorna uma lista de bairros")
	public ResponseEntity<List<Bairro>> findAll(){
		List<Bairro> listaBairro = (List<Bairro>) bairroService.allDistrict();
		return new ResponseEntity<List<Bairro>>(listaBairro, HttpStatus.OK);
	}


	@GetMapping(value ="/{id}")
	@ApiOperation(value="Retorna um único bairro")
	public ResponseEntity<Bairro> findById(@PathVariable (value = "id") Long id){
		return bairroService.bairroPorId(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	
	@PutMapping(value ="/{id}")
	@ApiOperation(value="Atualiza os registros de bairro")
	public ResponseEntity<Bairro> update(@PathVariable("id") Long id, @Valid @RequestBody Bairro bairro){
		return  ResponseEntity.ok(bairroService.alterarBairro(bairro));	
	}
	
	@DeleteMapping
	@ApiOperation(value="Exclui um registro de bairro")
	public ResponseEntity<?> delete(@PathVariable (value="id") Long id){
		return bairroService.bairroPorId(id)
				.map(record -> {
					bairroService.excluir(id);
					return ResponseEntity.ok().build();
				}) .orElse(ResponseEntity.notFound().build());
		
		
		
	}
	

}
