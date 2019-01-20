package com.ravel.contas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="c_pessoa_juridica", schema="public")
public class PessoaJuridica extends Pessoa{

	@Column(name="nr_cnpj", length=14, nullable=false)
	private String nrCnpj;
	
	@Column(name="nr_inscricao_estadual", length=30, nullable=true)
	private String nrInscricaoEstadual;
	
	@Column(name="nr_inscricao_municipal", length=30, nullable=true)
	private String nrInscricaoMunicipal;
	
	@Column(name="ds_nome_fantasia", length=50, nullable=false)
	private String dsNomeFantasia;
}

