package com.medeova.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotEmpty(message = " codigo is required ")
    private String codigo;
    @NotBlank(message = " perNom is required ")
    private String priNombre;
    @NotBlank(message = " perApell is required ")
    private String priApellido;
    private String secNombre;
    private String secApellido;
    @Email
    @NotEmpty(message = " email is required ")
    private String email;
    @NotBlank (message = " clave is required ")
    private String password;

}
