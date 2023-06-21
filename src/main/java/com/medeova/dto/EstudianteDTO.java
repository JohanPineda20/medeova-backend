package com.medeova.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDTO {

    private String codigo;
    private String priNombre;
    private String priApellido;
    private String secNombre;
    private String secApellido;
    private String email;
}
