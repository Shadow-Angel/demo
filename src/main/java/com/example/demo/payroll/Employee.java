package com.example.demo.payroll;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data // Es una anotación de Lombok para crear todos los getters, setters, equals, hash, y toStringmétodos, basados en los campos.
@Entity // es una anotación JPA para preparar este objeto para el almacenamiento en un almacén de datos basado en JPA.
public class Employee {
    private  @Id @GeneratedValue Long id; // se marca con más anotaciones JPA para indicar que es la clave principal y que el proveedor JPA completa automáticamente.
    private String nombre;
    private String rol;

    Employee(){}

    Employee(String nombre, String rol){
        this.nombre = nombre;
        this.rol = rol;
    }
}
