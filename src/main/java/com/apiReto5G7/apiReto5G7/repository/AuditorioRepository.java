/*
 * Creación de repositorio para la tabla Auditorio.
 */
package com.apiReto5G7.apiReto5G7.repository;

import com.apiReto5G7.apiReto5G7.entity.Auditorio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author J. Sebastián Beltrán
 */
public interface AuditorioRepository extends JpaRepository <Auditorio, Integer> {
    
}
