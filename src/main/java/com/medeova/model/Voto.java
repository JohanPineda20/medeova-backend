package com.medeova.model;

import java.io.Serializable;

import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "voto")
public class Voto implements Serializable
{	
	@EmbeddedId
	private VotoPK votoPK;
	
	@Column(name = "valoracion")
	private Integer valoracion;
	
	private static final long serialVersionUID = 1L;
	
}