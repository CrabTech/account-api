package com.ravel.contas.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public List<Agencia> getAll(){
		return agenciaService.recuperarTodas();
	}
	
	@RequestMapping(value="/recuperar/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getByAgencia(@PathVariable Integer id) {
		
		try {
			Agencia agenciaRecovery = new Agencia();
			agenciaRecovery = agenciaService.recuperarPorId(id);
			return new ResponseEntity<>(agenciaRecovery, HttpStatus.OK);
		} catch (Exception e) {
			String mensagem = e.getMessage().toString();
			return new ResponseEntity<>(mensagem,HttpStatus.PRECONDITION_FAILED);
		} 

	}
	
	@RequestMapping(value="/salvar", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  @ResponseBody void saveAgencia(@RequestBody Agencia ag) throws Exception {
		try {
			agenciaService.salvarAgencia(ag);
			
		} catch (Exception e) {
			new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED).getStatusCode();
		}
			
	}
	
	@Transactional
	@RequestMapping(value="/deletar/{id}", method=RequestMethod.DELETE)
	public  void deleteAgencia(@PathVariable Integer id) {
		 agenciaRepository.deleteById(id);
	}
	
	
	
}
