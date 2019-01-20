package com.ravel.contas.entity;


import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Embeddable
public class Uf {
	
	
	@NotNull
	@Size(max=20)
	private String dsUf;
	
	@NotNull
	@Size(max=2)
	private String dsSigla;
}
