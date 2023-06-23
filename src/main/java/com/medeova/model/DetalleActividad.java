package com.medeova.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(DetalleActividadId.class)
@Table(name = "detalle_actividad")
public class DetalleActividad implements Serializable
{	
	@Id
	@JoinColumn(name = "id_actividad", referencedColumnName = "id_actividad")
	@ManyToOne
	private Actividad actividad;
	
	@Id
	@JoinColumn(name = "id_usuario", referencedColumnName = "codigo")
	@ManyToOne
	private Usuario usuario;
	
	@Column(name = "dificultad")
	private Integer dificultad;
	
	@Column(name = "comentario")
	private String comentario;
	

	@Column(name ="created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
	
	@PrePersist
	private void Date(){
        this.createdAt = new Date();
    }
	
	private static final long serialVersionUID = 1L;
	
}