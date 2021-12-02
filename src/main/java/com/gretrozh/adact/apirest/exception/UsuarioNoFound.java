package com.gretrozh.adact.apirest.exception;

public class UsuarioNoFound extends RuntimeException{

    public UsuarioNoFound(String mensaje) {
        super(mensaje);
    }
}
