/*
 * Creación de repositorio para la tabla Cliente.
 */
package com.apiReto5G7.apiReto5G7.repository;

import com.apiReto5G7.apiReto5G7.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author J. Sebastián Beltrán S
 */
public interface ClienteRepository extends JpaRepository <Cliente, Integer> {
    
}
