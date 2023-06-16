package com.medeova.config.security;

import com.medeova.dao.UsuarioDAO;
import com.medeova.model.Rol;
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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UsuarioDAO usuarioDAO;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) {
        Optional<Usuario> usuarioOptional = usuarioDAO.findByEmail(email);
        Usuario usuario = usuarioOptional
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con email: " + email));

        return new UserDetailsImp(usuario.getCodigo(), usuario.getEmail(), usuario.getClave(), mapToAuthorities(usuario.getRoles()),
                usuario.isEnabled(), true, true,
                true);
    }

    private Collection<? extends GrantedAuthority> mapToAuthorities(List<Rol> roles) { //Convertimos la clase Rol a la clase GrantedAuthority
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }
}