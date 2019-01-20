package com.ravel.contas.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;


import lombok.*;

@Data
@MappedSuperclass
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="nr_telefone_fixo", nullable=true, length=45)
	private String nrTelefone;
	
	@Column(name="nr_telefone_celular", nullable=true, length=45)
	private String nrCelular;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_endereco", nullable=false)
	private Endereco endereco;
	
}
