package com.example.demo.payroll;

public class EmployeeNotFoundException extends RuntimeException{
    EmployeeNotFoundException(Long id){
        super("No se pudo encontrar al empleado " + id);
    }
    // Este tidbit adicional de la configuración Spring MVC se usa para representar un HTTP 404 :
}
