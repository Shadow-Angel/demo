package com.example.demo.payroll;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController // indica que los datos devueltos por cada método se escribirán directamente en el cuerpo de la respuesta en lugar de representar una plantilla.
public class EmployeeController {
    private final EmployeeRepository repositorio;

    EmployeeController(EmployeeRepository repositorio){ // An EmployeeRepositoryes inyectado por el constructor en el controlador.
        this.repositorio = repositorio;
    }

    /*Tenemos rutas para cada operación
     (@GetMapping, @PostMapping, @PutMapping y @DeleteMapping,
     lo que corresponde con HTTP GET, POST, PUT, y DELETE).*/

    // Agregar root
    @GetMapping("/employees")
    List<Employee> all(){
        return repositorio.findAll();
    }

    @PostMapping("/employees")
    Employee nuevoEmpleado(@RequestBody Employee nuevoEmpleado){
        return repositorio.save(nuevoEmpleado);
    }

    // Single item

    @GetMapping("/employees/{id}")
    Employee uno(@PathVariable Long id){
        return repositorio.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id)); // EmployeeNotFoundException es una excepción utilizada para indicar cuándo se busca un empleado pero no se lo encuentra.
    }

    @PutMapping("/employees/{id}")
    Employee remplazarEmpleado(@RequestBody Employee nuevoEmpleado, @PathVariable Long id){
        return repositorio.findById(id).map(employee -> {
            employee.setNombre(nuevoEmpleado.getNombre());
            employee.setRol(nuevoEmpleado.getRol());
            return repositorio.save(employee);
        }).orElseGet(() -> {
            nuevoEmpleado.setId(id);
            return repositorio.save(nuevoEmpleado);
        });
    }

    @DeleteMapping("/employees/{id}")
    void borrarEmpleado(@PathVariable Long id){
        repositorio.deleteById(id);
    }

}
