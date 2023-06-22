package com.medeova.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="usuarios_roles", joinColumns = @JoinColumn(name= "id_usuario", referencedColumnName = "codigo"),
    inverseJoinColumns = @JoinColumn(name="id_rol", referencedColumnName = "id"))
    private List<Rol> roles;
    
    private static final long serialVersionUID = 1L;	
}