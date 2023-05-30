package com.medeova.model;

import java.io.Serializable;

import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detalle_actividad")
public class DetalleActividad implements Serializable
{	
	@EmbeddedId
	private DetalleActividadPK detallePK;
	
	@Column(name = "dificultad")
	private Integer dificultad;
	
	@Column(name = "comentario")
	private String comentario;
	
	private static final long serialVersionUID = 1L;
	
}