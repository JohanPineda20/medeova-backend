package com.medeova.service.implementation;

import com.medeova.config.security.JwtProvider;
import com.medeova.dao.UsuarioRepository;
import com.medeova.dao.VerificationTokenRepository;
import com.medeova.dto.AuthenticationResponse;
import com.medeova.dto.LoginRequest;
import com.medeova.dto.RegisterRequest;
import com.medeova.exception.PersonalizedException;
import com.medeova.model.Usuario;
import com.medeova.model.VerificationToken;
import com.medeova.utils.MailService;
import com.medeova.utils.NotificationEmail;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
public class AuthService {

	private final PasswordEncoder passwordEncoder;
	private final UsuarioRepository usuarioRepository;
	private final VerificationTokenRepository verificationTokenRepository;
	private final MailService mailService;
	private final AuthenticationManager authenticationManager;

	private final UserDetailsService userDetailsService;
	private final JwtProvider jwtProvider;

	@Transactional
	public void signup (RegisterRequest registerRequest) {

		if (usuarioRepository.existsByCodigo(registerRequest.getCodigo())) {
			throw new IllegalArgumentException("El codigo ya está en uso");
		}

		if (usuarioRepository.existsByEmail(registerRequest.getEmail())) {
			throw new IllegalArgumentException("El correo electrónico ya está en uso");
		}

		Usuario usuario = new Usuario();
		usuario.setCodigo(registerRequest.getCodigo());
		usuario.setPerNom(registerRequest.getPriNombre());
		usuario.setPerApell(registerRequest.getPriApellido());
		usuario.setSdoNom(registerRequest.getSecNombre());
		usuario.setSdoApell(registerRequest.getSecApellido());
		usuario.setEmail(registerRequest.getEmail());
		usuario.setClave(passwordEncoder.encode(registerRequest.getPassword()));
		usuario.setCreated(Instant.now());
		usuario.setEnabled(false);

		usuarioRepository.save(usuario);

		String token = generateVerificationToken(usuario);

		mailService.sendMail(new NotificationEmail("Activación de cuenta MEDEOVA",usuario.getEmail(),"Gracias por registrarte a MEDEOVA, " +
				"por favor clic en el enlace para verificar la cuenta: " +
				"http://localhost:8080/api/auth/accountVerification/" + token));
	}

	private String generateVerificationToken(Usuario user) {
		String token = UUID.randomUUID().toString();
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setToken(token);
		verificationToken.setUsuario(user);

		verificationTokenRepository.save(verificationToken);
		return token;
	}

    public void verifyAccount(String token) {
		Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
		verificationToken.orElseThrow(() -> new PersonalizedException("Invalid Token"));
		enableUser(verificationToken.get());
    }
	private void enableUser(VerificationToken verificationToken) {
		String email= verificationToken.getUsuario().getEmail();
		Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(()->new PersonalizedException("User not found with email "+ email));
		usuario.setEnabled(true);
		usuarioRepository.save(usuario);
	}

	public AuthenticationResponse login(LoginRequest loginRequest){
		UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail()); //solo para que me genere la excepcion de UserNotFound y poder manejarlo
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
				loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		String token = jwtProvider.generateToken(authenticate);
		return new AuthenticationResponse(token);
	}
}
