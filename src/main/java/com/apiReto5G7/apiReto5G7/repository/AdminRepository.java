/*
 * Creación de repositorio para la tabla Admin.
 */
package com.apiReto5G7.apiReto5G7.repository;

import com.apiReto5G7.apiReto5G7.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author J. Sebastián Beltrán S
 */
public interface AdminRepository extends JpaRepository <Admin, Integer> {
    
}
