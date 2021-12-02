package com.gretrozh.adact.apirest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
public class ManejadorException {

    private static final int OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR_CODE = HttpStatus.BAD_REQUEST.value();
    private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "Ocurrió un error favor contactar al administrador.";
    private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

    public ManejadorException() {
        CODIGOS_ESTADO.put(UsuarioNoFound.class.getSimpleName(),HttpStatus.NOT_FOUND.value());
        CODIGOS_ESTADO.put(DependeciaNotFound.class.getSimpleName(),HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Error> probar(Exception exception){
        ResponseEntity<Error> error;
        String errorName= exception.getClass().getSimpleName();
        String mensaje = exception.getMessage();
        Integer codigo = CODIGOS_ESTADO.get(errorName);
        if(codigo!= null){
            Error newError = new Error(errorName,mensaje,codigo);
            error = new ResponseEntity<Error>(newError,HttpStatus.valueOf(codigo));
        }else{
            Error newError = new Error(errorName,
                    OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR,
                    OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR_CODE);
            error = new ResponseEntity<>(newError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return error;
    }

}
