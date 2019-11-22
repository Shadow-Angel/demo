package com.example.demo.payroll;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class EmployeeNotFoundAdvice {

    @ResponseBody //  indica que este consejo se presenta directamente en el cuerpo de respuesta.
    @ExceptionHandler(EmployeeNotFoundException.class) // configura el advice para responder en caso de un EmployeeNotFoundException
    @ResponseStatus(HttpStatus.NOT_FOUND) // dice emitir un HttpStatus.NOT_FOUND, es decir, un HTTP 404 .
    String empleadoNoEncontradoHandler(EmployeeNotFoundException ex){
        return ex.getMessage();
    }
}
