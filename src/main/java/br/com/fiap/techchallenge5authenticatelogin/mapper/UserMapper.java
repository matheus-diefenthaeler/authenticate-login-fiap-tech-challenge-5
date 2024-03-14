package br.com.fiap.techchallenge5authenticatelogin.mapper;

import br.com.fiap.techchallenge5authenticatelogin.dto.UserRequest;
import br.com.fiap.techchallenge5authenticatelogin.dto.UserResponse;
import br.com.fiap.techchallenge5authenticatelogin.entity.User;

public interface UserMapper {

    User requestToModel(UserRequest request);
    UserResponse modelToResponse(User user);
}
