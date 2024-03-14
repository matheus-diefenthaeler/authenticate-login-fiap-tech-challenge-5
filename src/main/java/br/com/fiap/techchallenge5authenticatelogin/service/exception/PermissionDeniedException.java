package br.com.fiap.techchallenge5authenticatelogin.service.exception;

public class PermissionDeniedException extends RuntimeException{
    public PermissionDeniedException(String msg){
        super(msg);
    }
}
