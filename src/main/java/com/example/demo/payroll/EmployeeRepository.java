package com.example.demo.payroll;

import  org.springframework.data.jpa.repository.JpaRepository;

/* Esta interfaz "extend" los JPA de Spring Data JpaRepository, especificando el tipo de dominio como Employee y el tipo de identificación como Long. Esta interfaz, aunque vacía en la superficie, tiene un gran impacto dado que admite:

Crear nuevas instancias

Actualización de las existentes

Borrando

Encontrar (uno, todos, por propiedades simples o complejas)
*/

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
}
