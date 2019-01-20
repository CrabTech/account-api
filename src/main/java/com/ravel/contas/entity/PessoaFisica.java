package com.ravel.contas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="c_pessoa_fisica", schema="public")
public class PessoaFisica extends Pessoa{

	
	@Column(name="nr_cpf",length=11, nullable=false )
	private String nrCpf;
	
	@Column(name="nr_identidade", length=20, nullable=false)
	private String nrIdentidade;
	
	@Column(name="ds_nome_pessoa", length=100, nullable=false)
	private String dsNomePessoa;
	
}
