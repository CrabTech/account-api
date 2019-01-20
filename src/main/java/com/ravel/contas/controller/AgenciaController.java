package com.ravel.contas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ravel.contas.entity.Agencia;
import com.ravel.contas.repository.AgenciaRepository;
import com.ravel.contas.repository.EnderecoRepository;

@RestController
@RequestMapping(value="/rest/agencia")
public class AgenciaController {
	
	@Autowired
	AgenciaRepository agenciaRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	
	@RequestMapping(value="/all", method=RequestMethod.GET )
	public List<Agencia> getAll(){
		return agenciaRepository.findAll();
	}
	
	
	@RequestMapping(value="/recuperar/{id}", method=RequestMethod.GET)
	public Agencia getByAgencia(@PathVariable Integer id) {
		return agenciaRepository.findById(id);
	}
	
	@RequestMapping(value="/salvar", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Agencia saveAgencia(@RequestBody Agencia ag) {
		return agenciaRepository.save(ag);
	}
	
}
