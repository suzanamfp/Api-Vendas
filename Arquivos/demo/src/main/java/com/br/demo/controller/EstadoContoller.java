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

import com.br.demo.model.entity.Estado;
import com.br.demo.service.impl.EstadoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


//@ResponseBody //Anotação usada para um método do controller não encaminhar uma requisição para página JSP
//O Spring, por padrão, converte os dados no formato JSON, utilizando a biblioteca Jackson;

@RestController //Anaotação usada para não repetir a anotação acima em todos os métodos do controller
@RequestMapping(value = "/estado", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value="API REST Estado")
@CrossOrigin(origins="*")
public class EstadoContoller {

	@Autowired 
	private EstadoService estadoService;

	//MÉTODOS CRUD

	@PostMapping 
	@ApiOperation(value = "Salva uma estado")
	public ResponseEntity<Estado> create (@RequestBody Estado estado) {
		return ResponseEntity.of(Optional.of(estadoService.novo(estado)));
	}

	@GetMapping(value ="/todos/teste")
	@ApiOperation(value = "Retorna uma lista de estados")
	public ResponseEntity<List<Estado>> findAll(){//O método findAll é direto ao ponto: utiliza o método findAll da interface JpaRepository que faz um select * from estado.
		List<Estado> listaEstado = (List<Estado>) estadoService.estados();
		return new ResponseEntity<List<Estado>>(listaEstado, HttpStatus.OK); 
	}

	@GetMapping(value ="/{id}")
	@ApiOperation(value = "Retorna um único estado")
	public ResponseEntity <Estado> findById(@PathVariable (value = "id") Long id) { //Esse método retorna apenas o id que estamos procurando dentro de Estado
		return estadoService.estadoPorId(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping (value="/{id}")
	@ApiOperation(value = "Atualiza os registros de estado")
	public ResponseEntity<Estado> update (@PathVariable("id") Long id, @Valid @RequestBody Estado estado) { //Atualiza os dados que foram inseridos atraves do ID
		return  ResponseEntity.ok(estadoService.alterar(estado));
	}

	@DeleteMapping(path ="/{id}")
	@ApiOperation(value = "Exclui um registro de estado")
	public ResponseEntity <?> delete(@PathVariable Long id){ //remove um estado pelo ID
		return estadoService.estadoPorId(id)
				.map(record -> {
					estadoService.excluir(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}









}


/*
 * Métodos da request: - GET para fazer leitura. Se disparar uma requisição GET
 * para o recurso /alunos é porque quero recuperar os recursos (alunos). - POST
 * para cadastrar, - PUT é atualizar 
 * - DELETE é para excluir.
 */
