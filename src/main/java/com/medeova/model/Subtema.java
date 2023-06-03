package com.medeova.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subtema")
public class Subtema implements Serializable
{	
	@Id
	@Column(name = "id_subtema")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSubtema;
	
	@JoinColumn(name = "id_tema", referencedColumnName = "id_tema")
	@ManyToOne
    private Tema tema;
	
	@Column(name = "titulo")
	private String titulo;

	@Column(name = "imagen")
	private String img;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "contenido")
	private String contenido;
	
	@OneToMany(mappedBy = "subtema", orphanRemoval = true)
    private List<Multimedia> multimedia;
	
	
	private static final long serialVersionUID = 1L;	
}