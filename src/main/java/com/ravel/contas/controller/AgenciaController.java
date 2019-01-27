package com.ravel.contas.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ravel.contas.entity.Agencia;
import com.ravel.contas.repository.AgenciaRepository;
import com.ravel.contas.repository.EnderecoRepository;
import com.ravel.contas.service.AgenciaService;


@RestController
@RequestMapping(value="/rest/agencia")
public class AgenciaController {
	
	@Autowired
	AgenciaRepository agenciaRepository;
	
	@Autowired
	AgenciaService agenciaService;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<List<Agencia>> getAll(){
		List<Agencia> all = this.agenciaService.recuperarTodas();
		if (CollectionUtils.isEmpty(all)) {
			return new ResponseEntity<List<Agencia>>(HttpStatus.NO_CONTENT);
		} else {
			return ResponseEntity.ok(all);
		}
		
	}
	
	@RequestMapping(value="/recuperar/{id}", method=RequestMethod.GET)
	public ResponseEntity<Agencia> getByAgencia(@PathVariable Integer id) {
		Agencia ag = this.agenciaService.recuperarPorId(id);
		if(Objects.isNull(ag)) {
			return new ResponseEntity<Agencia>(HttpStatus.NO_CONTENT);
		} else {
			return ResponseEntity.ok(ag);
		}
	}
	
	@RequestMapping(value="/salvar", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  ResponseEntity<Agencia> saveAgencia(@RequestBody @Valid Agencia ag) {
		Agencia agencia = this.agenciaService.salvarAgencia(ag);
		
		if (Objects.isNull(agencia)) {
			return new ResponseEntity<Agencia>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return ResponseEntity.ok(agencia);
		}
		
		
			
	}
	
	@Transactional
	@RequestMapping(value="/deletar/{id}", method=RequestMethod.DELETE)
	public  void deleteAgencia(@PathVariable Integer id) {
		 agenciaRepository.deleteById(id);
	}
	
	
	
}
