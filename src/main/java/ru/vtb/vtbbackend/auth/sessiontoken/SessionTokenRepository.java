package ru.vtb.vtbbackend.auth.sessiontoken;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionTokenRepository extends JpaRepository<SessionToken, Long> {

    public SessionToken getSessionTokenBySession(String session);
}