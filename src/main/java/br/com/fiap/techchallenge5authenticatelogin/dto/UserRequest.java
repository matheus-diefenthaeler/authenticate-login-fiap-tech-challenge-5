package br.com.fiap.techchallenge5authenticatelogin.dto;

import br.com.fiap.techchallenge5authenticatelogin.entity.enums.UserRole;
import lombok.Getter;

@Getter
public class UserRequest {

    private String login;
    private String password;
    private UserRole userRole;
}
