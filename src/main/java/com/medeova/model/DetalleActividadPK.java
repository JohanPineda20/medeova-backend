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

public class DetalleActividadPK implements Serializable 
{
	private String id_usuario;
	private Integer id_actividad;
		
	private static final long serialVersionUID = 1L;

}
