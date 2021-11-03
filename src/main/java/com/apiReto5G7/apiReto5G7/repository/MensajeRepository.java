/*
 * Creación de repositorio para la tabla Mensaje.
 */
package com.apiReto5G7.apiReto5G7.repository;

import com.apiReto5G7.apiReto5G7.entity.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author J. Sebastián Beltrán S
 */
public interface MensajeRepository extends JpaRepository <Mensaje, Integer> {
    
}
