package com.medeova.config.security;

import com.medeova.exception.PersonalizedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.Date;


@Service
public class JwtProvider {

    private KeyStore keyStore;

    @PostConstruct
    public void init() {
        try {
            keyStore = KeyStore.getInstance("JKS");
            InputStream resourceAsStream = getClass().getResourceAsStream("/springblog.jks");
            keyStore.load(resourceAsStream, "secret".toCharArray());
        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
            throw new PersonalizedException("Exception occurred while loading keystore");
        }

    }

    public String generateToken(Authentication authentication) {
        UserDetailsImp userDetails = (UserDetailsImp) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 3600000);
        return Jwts.builder()
                .claim("id", userDetails.getCodigo())
                .claim("rol", userDetails.getAuthorities())
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(getPrivateKey())
                .compact();
    }

    private PrivateKey getPrivateKey() {
        try {
            return (PrivateKey) keyStore.getKey("springblog", "secret".toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new PersonalizedException("Exception occured while retrieving public key from keystore");
        }
    }

    // Valida la firma y expiracion de un token
    @SuppressWarnings("deprecation")
	public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(getPrivateKey()).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            // El token es inválido o ha expirado
            return false;
        }
    }

    // Obtiene el nombre de usuario a partir del token
    @SuppressWarnings("deprecation")
	public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(getPrivateKey()).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

}


