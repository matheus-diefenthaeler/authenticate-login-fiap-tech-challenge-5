package br.com.fiap.techchallenge5authenticatelogin.controller;

import br.com.fiap.techchallenge5authenticatelogin.dto.UserAuthRequest;
import br.com.fiap.techchallenge5authenticatelogin.dto.UserRequest;
import br.com.fiap.techchallenge5authenticatelogin.dto.UserResponse;
import br.com.fiap.techchallenge5authenticatelogin.dto.UserTokenResponse;
import br.com.fiap.techchallenge5authenticatelogin.entity.User;
import br.com.fiap.techchallenge5authenticatelogin.mapper.impl.UserMapperImpl;
import br.com.fiap.techchallenge5authenticatelogin.security.TokenService;
import br.com.fiap.techchallenge5authenticatelogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapperImpl mapper;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserAuthRequest data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new UserTokenResponse(token));
    }
    @PostMapping("/register")
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
        User user = userService.create(request);
        UserResponse userResponse = mapper.modelToResponse(user);

        return ResponseEntity.ok().body(userResponse);
    }
}
