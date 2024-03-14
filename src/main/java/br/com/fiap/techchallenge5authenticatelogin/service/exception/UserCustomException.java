package br.com.fiap.techchallenge5authenticatelogin.service.exception;

public class UserCustomException extends RuntimeException{
    public UserCustomException(String msg){
        super(msg);
    }
}
