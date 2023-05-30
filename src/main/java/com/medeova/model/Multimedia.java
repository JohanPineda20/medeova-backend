package com.medeova.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "multimedia")
public class Multimedia implements Serializable
{	
	@Id
	@Column(name = "id_multimedia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMultimedia;
	
	@JoinColumn(name = "id_subtema", referencedColumnName = "id_subtema")
	@ManyToOne
	@JsonIgnore
    private Subtema subtema;
	
	@Column(name = "titulo")
	private String titulo;

	@Column(name = "enlace")
	private String url;
	
	@Column(name = "observacion")
	private String observacion;
	
	private static final long serialVersionUID = 1L;	
}