package br.com.fiap.techchallenge5authenticatelogin.repository;

import br.com.fiap.techchallenge5authenticatelogin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLoginAndPassword(String login, String pwd);

    UserDetails findByLogin(String login);
}
