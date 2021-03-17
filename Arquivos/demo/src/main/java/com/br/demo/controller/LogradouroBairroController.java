
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

import com.br.demo.model.entity.LogradouroBairro;
import com.br.demo.service.impl.LogradouroBairroService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/logradouroBairro", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value="API REST LogradouroBairro")
@CrossOrigin(origins="*")
public class LogradouroBairroController {
	
	@Autowired
	private LogradouroBairroService logradouroBairroService;
	
	@PostMapping
	@ApiOperation(value="Cria um novo logradouro")
	private ResponseEntity<LogradouroBairro> create(@RequestBody LogradouroBairro logradouroBairro){
		return ResponseEntity.of(Optional.of(logradouroBairroService.novo(logradouroBairro)));
	}
	
	@GetMapping(value="/logradouroBairro")
	@ApiOperation(value="Retorna uma lista de logradouros com Bairro")
	private ResponseEntity<List<LogradouroBairro>> findAll(){
		List<LogradouroBairro> listaLograBairro = (List<LogradouroBairro>) logradouroBairroService.allLograBairro();
		return new ResponseEntity<List<LogradouroBairro>>(listaLograBairro, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	@ApiOperation(value="Retorna um único logradouro com Bairro")
	private ResponseEntity<LogradouroBairro> findById(@PathVariable (value = "id") Long id){
			return logradouroBairroService.logradouroBairroPorId(id)
					.map(record -> ResponseEntity.ok().body(record))
					.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value ="/{id}")
	@ApiOperation(value="Atualiza os registros de logradouro com Bairro")
	public ResponseEntity<LogradouroBairro> update(@PathVariable("id") Long id, @Valid @RequestBody LogradouroBairro logradouroBairro){
		return  ResponseEntity.ok(logradouroBairroService.alterarLograBairro(logradouroBairro));	
	}
	
	@DeleteMapping
	@ApiOperation(value="Exclui um registro de logradouro com Bairro")
	public ResponseEntity<?> delete(@PathVariable (value="id") Long id){
		return logradouroBairroService.logradouroBairroPorId(id)
				.map(record -> {
					logradouroBairroService.excluir(id);
					return ResponseEntity.ok().build();
				}) .orElse(ResponseEntity.notFound().build());
	}
}
