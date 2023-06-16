package com.medeova.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comentario")
public class Comentario implements Serializable
{	
	@Id
	@Column(name = "id_comentario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idComentario;
	
	@JoinColumn(name = "id_tema", referencedColumnName = "id_tema")
	@ManyToOne
    private Tema tema;
	
	@JoinColumn(name = "id_usuario", referencedColumnName = "codigo")
	@ManyToOne
    private Usuario usuario;
	
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