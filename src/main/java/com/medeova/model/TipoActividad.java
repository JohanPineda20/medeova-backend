package com.medeova.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipo_actividad")
public class TipoActividad implements Serializable {

	@Id
	@Column(name = "id_tipo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipo;
	
	@Column(name = "nombre")
	private String nombre;
	
	/*@OneToMany(mappedBy = "tipoActividad", orphanRemoval = true)
    @JsonIgnore
    private List<Actividad> actividades;*/
	
	private static final long serialVersionUID = 1L;
	
}