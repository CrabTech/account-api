package com.ravel.contas.repository;

import org.springframework.stereotype.Repository;

import com.ravel.contas.entity.Agencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
	
	Agencia findById(Integer id);
	
	List<Agencia> findAll();
	
	Agencia save(Agencia ag);
	
	Agencia deleteById(Integer id);
}
