package com.medeova.service.implementation;

import com.medeova.config.security.JwtProvider;
import com.medeova.dao.RolDAO;
import com.medeova.dao.UsuarioDAO;
import com.medeova.dao.VerificationTokenDAO;
import com.medeova.dto.LoginResponse;
import com.medeova.dto.LoginRequest;
import com.medeova.dto.RegisterRequest;
import com.medeova.exception.PersonalizedException;
import com.medeova.model.Rol;
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
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
public class AuthService {

	private final PasswordEncoder passwordEncoder;
	private final UsuarioDAO usuarioDAO;
	private final VerificationTokenDAO verificationTokenDAO;
	private final MailService mailService;
	private final AuthenticationManager authenticationManager;

	private final RolDAO rolDAO;
	private final UserDetailsService userDetailsService;
	private final JwtProvider jwtProvider;

	@Transactional
	public void signup (RegisterRequest registerRequest) {

		if (usuarioDAO.existsByCodigo(registerRequest.getCodigo())) {
			throw new IllegalArgumentException("El codigo ya está en uso");
		}

		if (usuarioDAO.existsByEmail(registerRequest.getEmail())) {
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
		Rol rol = rolDAO.findByNombre("USER").get();
		usuario.setRoles(Collections.singletonList(rol));

		usuarioDAO.save(usuario);

		String token = generateVerificationToken(usuario);

		mailService.sendMail(new NotificationEmail("Activación de cuenta MEDEOVA",usuario.getEmail(),"Gracias por registrarte a MEDEOVA, " +
				"por favor clic en el enlace para verificar la cuenta: " +
				"https://medeova-backend-production.up.railway.app/api/auth/accountVerification/" + token));
	}

	private String generateVerificationToken(Usuario user) {
		String token = UUID.randomUUID().toString();
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setToken(token);
		verificationToken.setUsuario(user);

		verificationTokenDAO.save(verificationToken);
		return token;
	}

	@Transactional
    public void verifyAccount(String token) {
		Optional<VerificationToken> verificationToken = verificationTokenDAO.findByToken(token);
		verificationToken.orElseThrow(() -> new PersonalizedException("Invalid Token"));
		enableUser(verificationToken.get());
    }
	private void enableUser(VerificationToken verificationToken) {
		String email= verificationToken.getUsuario().getEmail();
		Usuario usuario = usuarioDAO.findByEmail(email).orElseThrow(()->new PersonalizedException("User not found with email "+ email));
		usuario.setEnabled(true);
		usuarioDAO.save(usuario);
	}

	public LoginResponse login(LoginRequest loginRequest){
		@SuppressWarnings("unused")
		UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail()); //solo para que me genere la excepcion de UserNotFound y poder manejarlo
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
				loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		String token = jwtProvider.generateToken(authenticate);
		return new LoginResponse(token);
	}
}
