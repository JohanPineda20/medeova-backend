package com.medeova.model;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	
	@Id
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "per_nom")
    private String perNom;
    
    @Column(name = "sdo_nom")
    private String sdoNom;
    
    @Column(name = "per_apell")
    private String perApell;
    
    @Column(name = "sdo_apell")
    private String sdoApell;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "clave")
    private String clave;

    @Column(name = "created")
    private Instant created;

    @Column(name = "enabled")
    private boolean enabled;
    
    private static final long serialVersionUID = 1L;	
}