package com.gretrozh.adact.apirest.exception;

public class DependeciaNotFound extends RuntimeException{
    public DependeciaNotFound(String mensaje) {
        super(mensaje);
    }
}
