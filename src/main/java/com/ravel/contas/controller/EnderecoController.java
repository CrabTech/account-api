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

import com.ravel.contas.entity.Endereco;
import com.ravel.contas.repository.EnderecoRepository;

@RestController
@RequestMapping("/rest/endereco")
public class EnderecoController {
 
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<Endereco> getAllEndereco(){
		return enderecoRepository.findAll();
	}
	
	@RequestMapping(value="/recuperar/{id}", method=RequestMethod.GET)
	public Endereco getOneEndereco(@PathVariable Integer id) {
		return enderecoRepository.findById(id);
	}
	
	@RequestMapping(value="/salvar", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  @ResponseBody Endereco saveEndereco(@RequestBody Endereco end) {
			
			return enderecoRepository.save(end); 

	}
	 	
}
