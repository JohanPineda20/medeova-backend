package com.medeova.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@Column(name = "imagen")
	private String img;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@OneToMany(mappedBy = "unidad", orphanRemoval = true)
	@JsonIgnore
    private List<Tema> temas;
	
	private static final long serialVersionUID = 1L;	
}