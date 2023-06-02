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
@Table(name = "tema")
public class Tema implements Serializable
{	
	@Id
	@Column(name = "id_tema")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTema;
	
	@JoinColumn(name = "id_unidad", referencedColumnName = "id_unidad")
	@ManyToOne
    private Unidad unidad;
	
	@Column(name = "titulo")
	private String titulo;

	@Column(name = "imagen")
	private String img;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@OneToMany(mappedBy = "tema", orphanRemoval = true)
	@JsonIgnore
    private List<Subtema> subtemas;
	
	private static final long serialVersionUID = 1L;	
}