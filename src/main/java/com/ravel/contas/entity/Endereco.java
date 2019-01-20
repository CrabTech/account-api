package com.ravel.contas.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;


@Entity
@Table(name="c_endereco", schema="public")
public @Data class Endereco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="ds_logradouro", nullable=false, length=45)
	private String dsLogradouro;
	
	@Column(name="ds_nr_logradouro", nullable=false, length=9)
	private String nrLogradouro;
	
	@Embedded
	@AttributeOverrides(value = {
	@AttributeOverride(name="dsMunicipio", column = @Column(name="ds_municipio")),
	@AttributeOverride(name="coCep", column = @Column(name="nr_cep"))
	})
	private Municipio municipio;
	

	@Embedded
	@AttributeOverrides(value = {
	@AttributeOverride(name="dsUf", column = @Column(name="ds_uf")),
	@AttributeOverride(name="dsSigla", column = @Column(name="ds_uf_sigla"))
			
	})
	private Uf uf;
	
}
