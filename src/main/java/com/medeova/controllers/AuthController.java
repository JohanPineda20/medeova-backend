package com.medeova.controllers;

import com.medeova.dto.LoginResponse;
import com.medeova.dto.LoginRequest;
import com.medeova.dto.RegisterRequest;
import com.medeova.dto.RegisterResponse;
import com.medeova.service.implementation.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Validated
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class AuthController {

	private final AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<RegisterResponse> signup (@Valid @RequestBody RegisterRequest registerRequest) {
		authService.signup(registerRequest);
		return ResponseEntity.ok(new RegisterResponse("Usuario creado exitosamente"));
	}

	@GetMapping("accountVerification/{token}")
	public ResponseEntity<String> verifyAccount(@PathVariable String token){
		authService.verifyAccount(token);
		return new ResponseEntity<>("Successful user verification", HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
	    return ResponseEntity.ok(authService.login(loginRequest));
	}
}
