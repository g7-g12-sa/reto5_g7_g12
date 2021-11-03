/*
 * Creación de repositorio para la tabla Calificacion.
 */

package com.apiReto5G7.apiReto5G7.repository;

import com.apiReto5G7.apiReto5G7.entity.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author J. Sebastián Beltrán
 */
public interface CalificacionRepository extends JpaRepository<Calificacion, Integer>{
    
}
