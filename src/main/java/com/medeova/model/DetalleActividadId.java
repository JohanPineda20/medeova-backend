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
	private Usuario usuario;
	private Actividad actividad;
		
	private static final long serialVersionUID = 1L;

}
