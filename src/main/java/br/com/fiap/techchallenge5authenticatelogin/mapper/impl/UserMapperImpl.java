package br.com.fiap.techchallenge5authenticatelogin.mapper.impl;

import br.com.fiap.techchallenge5authenticatelogin.dto.UserRequest;
import br.com.fiap.techchallenge5authenticatelogin.dto.UserResponse;
import br.com.fiap.techchallenge5authenticatelogin.entity.User;
import br.com.fiap.techchallenge5authenticatelogin.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User requestToModel(UserRequest request) {
        return new User(request.getLogin(),
                request.getPassword(),
        request.getUserRole());
    }

    @Override
    public UserResponse modelToResponse(User user) {
        return new UserResponse(user.getId(), user.getLogin(), user.getPassword());
    }


}
