package com.example.demo.payroll;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j // es una anotación de Lombok a autocreate una red basada en SLF4J
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repositorio){ // Spring Boot ejecutará TODOS los CommandLineRunner beans una vez que se cargue el contexto de la aplicación.
        // Este runner solicitará una copia del EmployeeRepositoryque acaba de crear.
        return args -> {
            log.info("Pre-cargando " + repositorio.save(new Employee("Bilbo Baggins","burglar")));
            log.info("Pre-cargando " + repositorio.save(new Employee("Frodo Baggins","thiefr")));
            // LoggerFactory loglo que nos permite "registrar" (log en español) estos recién creados "empleados".
        };
    }
}
