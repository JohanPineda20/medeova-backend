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
public class VotoPK implements Serializable 
{
	private String id_estudiante;
	private Integer id_multimedia;
		
	private static final long serialVersionUID = 1L;

}
