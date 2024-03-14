package br.com.fiap.techchallenge5authenticatelogin.service.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String msg){
        super(msg);
    }
}
