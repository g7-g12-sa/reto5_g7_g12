/*
 * Creación de repositorio para la tabla Categoria.
 */
package com.apiReto5G7.apiReto5G7.repository;

import com.apiReto5G7.apiReto5G7.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author J. Sebastián Beltrán
 */
public interface CategoriaRepository extends JpaRepository <Categoria, Integer> {
    
}
