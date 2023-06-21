package com.medeova.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "actividad")
public class Actividad implements Serializable
{	
	@Id
	@Column(name = "id_actividad")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idActividad;
	
	@JoinColumn(name = "id_tema", referencedColumnName = "id_tema")
	@ManyToOne
    private Tema tema;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "objetivo")
	private String objetivo;
	
	@Column(name = "instrucciones")
	private String instrucciones;
	
	@Column(name = "enlace")
	private String url;
	
	private static final long serialVersionUID = 1L;	
}