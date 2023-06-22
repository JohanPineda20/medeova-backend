package com.medeova.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DetalleActividadId implements Serializable 
{
	private Integer actividad;
	private String usuario;
		
	private static final long serialVersionUID = 1L;

}
