package com.medeova.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "unidad")
public class Unidad implements Serializable
{	
	@Id
	@Column(name = "id_unidad")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUnidad;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	private static final long serialVersionUID = 1L;	
}