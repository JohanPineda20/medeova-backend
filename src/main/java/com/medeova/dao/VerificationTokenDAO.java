package com.medeova.dao;

import com.medeova.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface VerificationTokenDAO extends JpaRepository<VerificationToken,Long> {
    Optional<VerificationToken> findByToken(String token);
}
