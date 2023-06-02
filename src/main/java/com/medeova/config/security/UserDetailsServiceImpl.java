package com.medeova.config.security;

import com.medeova.dao.UsuarioRepository;
import com.medeova.model.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

import static java.util.Collections.singletonList;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);
        Usuario usuario = usuarioOptional
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con email: " + email));

        return new UserDetailsImp(usuario.getCodigo(), usuario.getEmail(), usuario.getClave(), getAuthorities("ESTUDIANTE"),
                usuario.isEnabled(), true, true,
                true);
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) { //Convertimos la clase Rol a la clase GrantedAuthority
        return singletonList(new SimpleGrantedAuthority(role));
    }
}