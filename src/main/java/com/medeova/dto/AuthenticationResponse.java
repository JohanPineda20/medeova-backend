package com.medeova.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class AuthenticationResponse {
    private String token;
}