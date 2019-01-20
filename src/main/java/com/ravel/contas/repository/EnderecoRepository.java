package com.ravel.contas.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ravel.contas.entity.Endereco;



@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	Endereco save(Endereco end);
	
	Endereco findById(Integer id);
	
	List<Endereco> findAll();
	
	Endereco deleteById(Integer id);	
	
}
 	