/*
 * Creación de API /Category/ con peticiones GET y POST.
 */
package com.apiReto5G7.apiReto5G7.controller;

import com.apiReto5G7.apiReto5G7.entity.Categoria;
import com.apiReto5G7.apiReto5G7.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author J. Sebastián Beltrán
 */
@RestController
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Category")
public class CategoryController {
    /**
     * Instancia de CategoryService.
     */
    @Autowired
    private CategoryService servicioCategory;
    
    /**
     * Petición GET para API Categoria.
     * @return lista de categorías encontradas.
     */
    @GetMapping("/all")
    public List<Categoria> getAllCategorias(){
        return servicioCategory.getAllCategorias();
    }
    
    /**
     * Petición POST para API Categoria.
     * @param categoria el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PostMapping("/save")
    public ResponseEntity saveCategoria(@RequestBody Categoria categoria){
        servicioCategory.saveCategoria(categoria);
        
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Petición PUT para API Categoria.
     * @param categoria el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PutMapping("/update")
    public ResponseEntity updateCategoria(@RequestBody Categoria categoria){
        servicioCategory.updateCategoria(categoria);
        
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Petición POST para API Categoria.
     * @param idCategoria el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategoria(@PathVariable("id") int idCategoria){
        servicioCategory.deleteCategoria(idCategoria);
        
        return ResponseEntity.status(204).build();
    }
}