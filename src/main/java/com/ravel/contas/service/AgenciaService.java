package com.ravel.contas.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mysql.fabric.Response;
import com.ravel.contas.entity.Agencia;
import com.ravel.contas.repository.AgenciaRepository;

@Service
public class AgenciaService {

	@Autowired
	AgenciaRepository agenciaRepository;

	
	@Transactional
	public Agencia salvarAgencia(Agencia ag) {
		
		Agencia agenciaPersist = new Agencia();
		
		agenciaPersist.setCdAgencia(ag.getCdAgencia());
		agenciaPersist.setEndereco(ag.getEndereco());
		
		
		if(agenciaPersist.getCdAgencia() == null || agenciaPersist.getEndereco() == null) {
			respostaCondicaoFalsa();
		} 
		return agenciaRepository.save(agenciaPersist);
	}


	private ResponseEntity<String> respostaCondicaoFalsa() {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
	}
	
}
