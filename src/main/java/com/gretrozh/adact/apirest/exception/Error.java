package com.gretrozh.adact.apirest.exception;

import lombok.Data;
import lombok.Getter;

@Getter
public class Error {

    private String nombreExcpetion;
    private String mensaje;
    private Integer codigo;

    public Error(String nombreExcpetion, String mensaje, Integer codigo) {
        this.nombreExcpetion = nombreExcpetion;
        this.mensaje = mensaje;
        this.codigo = codigo;
    }
}
