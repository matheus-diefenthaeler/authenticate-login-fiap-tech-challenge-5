package br.com.fiap.techchallenge5authenticatelogin.service;

import br.com.fiap.techchallenge5authenticatelogin.dto.UserRequest;
import br.com.fiap.techchallenge5authenticatelogin.entity.User;
import br.com.fiap.techchallenge5authenticatelogin.mapper.impl.UserMapperImpl;
import br.com.fiap.techchallenge5authenticatelogin.repository.UserRepository;
import br.com.fiap.techchallenge5authenticatelogin.service.exception.UserCustomException;
import br.com.fiap.techchallenge5authenticatelogin.service.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapperImpl mapper;

    public void verifyUser(String login, String password) {
        Optional<User> user = userRepository.findByLoginAndPassword(login, password);
        var entity = user.orElseThrow(() -> new UserNotFoundException("User not found!"));
    }

    public User create(UserRequest request) {
        if (isUserCreated(request)) {
            throw new UserCustomException("Account already registred!");
        }

        User user = mapper.requestToModel(request);

        return userRepository.save(user);
    }

    public Boolean isUserCreated(UserRequest request) {
        return userRepository.findByLoginAndPassword(request.getLogin(), request.getPassword()).isPresent();
    }
}
