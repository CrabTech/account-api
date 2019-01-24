package com.ravel.contas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ravel.contas.entity.Agencia;
import com.ravel.contas.repository.AgenciaRepository;

@Service
public class AgenciaService {

	@Autowired
	AgenciaRepository agenciaRepository;

	
	@Transactional 
	public Agencia salvarAgencia(Agencia ag) throws Exception {
		
		Agencia agenciaPersist = new Agencia();
	
		agenciaPersist.setCdAgencia(ag.getCdAgencia());
		agenciaPersist.setEndereco(ag.getEndereco());
		
		if(agenciaPersist.getCdAgencia() == null || agenciaPersist.getEndereco() == null) {
			throw new Exception();
		} 
		return agenciaRepository.save(agenciaPersist);
	}


	public List<Agencia> recuperarTodas() {
		return agenciaRepository.findAll();
	}


	public Agencia recuperarPorId(Integer id) throws Exception {
		
		Agencia agenciaRecuperada = agenciaRepository.findById(id); 
		
		if(agenciaRecuperada == null) {
			throw new Exception();
		} 
		
		return agenciaRecuperada;
	}

	
}
