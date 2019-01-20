package com.ravel.contas.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Embeddable
public class Municipio {

	
	@NotNull
	@Size(max=120)
	private String dsMunicipio;
	
	@NotNull
	@Size(max=8)
	private Integer coCep;
	
	
}
