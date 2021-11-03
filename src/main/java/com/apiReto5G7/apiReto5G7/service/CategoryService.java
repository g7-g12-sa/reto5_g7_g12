/*
 * Creación de servicio para la ejecución de operaciones GET y POST en tabla
 * Categoria.
 */
package com.apiReto5G7.apiReto5G7.service;

import com.apiReto5G7.apiReto5G7.entity.Categoria;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apiReto5G7.apiReto5G7.repository.CategoriaRepository;

/**
 *
 * @author J. Sebastián Beltrán
 */
@Service
public class CategoryService {
    @Autowired
    private CategoriaRepository repositorioCategory;
    
    /**
     * Devuelve una lista con los registros de la tabla Categoria.
     * @return la lista con los objetos Categoria de la tabla Categoria.
     */
    public List<Categoria> getAllCategorias(){
        return repositorioCategory.findAll();
    }
    
    /**
     * Recupera una categoría específica de la tabla Categoria.
     * @param idCategoria el id del objeto que se recuperará.
     * @return el objeto Categoria si existe.
     */
    public Optional<Categoria> getCategoria(int idCategoria){
        return repositorioCategory.findById(idCategoria);
    }
    
    /**
     * Crea una nueva categoria en la tabla Categoria.
     * @param categoria la categoría que se creará.
     * @return un objeto Categoria
     */
    public Categoria saveCategoria(Categoria categoria){
        /**
         * Si categoria no tiene ID, guardarlo.
         */
        if(categoria.getId()==null){
            return repositorioCategory.save(categoria);        
        } else {
            /**
             * Busca el categoria por el ID, si lo encuentra, lo guarda en
             * existeCat.
             */
            Optional<Categoria> existeCat = getCategoria(categoria.getId());
            /**
             * Si existeCat está vacío, guardar categoria. Si no, devolver
             * categoria.
             */
            if(existeCat.isEmpty()){
                return repositorioCategory.save(categoria);
            } else {
                return categoria;
            }
        }
    }
    
    /**
     * Actualiza los valores de una categoria en la tabla Categoria.
     * @param categoria la Categoria con los valores a actualizar.
     * @return el objeto categoria actualizado.
     */
    public Categoria updateCategoria(Categoria categoria){
        /**
         * Verificar que el objeto auditorio recibido tenga un ID.
         */
        if (categoria.getId()!=null){
            /**
             * Verificar la existencia del objeto en BD.
             */
            Optional<Categoria> existeCategoria = getCategoria(categoria.getId());
            /**
             * Si el objeto existe en la BD, editarlo. Si no,retornarlo como
             * está.
             */
            if (!existeCategoria.isEmpty()){
                /**
                 * Si el objeto categoria tiene un valor name, asignarlo a
                 * existeCategoria.
                 */
                if (categoria.getName()!=null){
                    existeCategoria.get().setName(categoria.getName());
                }
                /**
                 * Si el objeto categoria tiene un valor description, asignarlo
                 * a existeCategoria.
                 */
                if (categoria.getDescription()!=null){
                    existeCategoria.get().setDescription(categoria.getDescription());
                }
                /**
                 * Devolver existeCategoria con valores ajustados.
                 */
                return repositorioCategory.save(existeCategoria.get());
            } else {
                return categoria;
            }
        } else {
            return categoria;
        }
    }
    
    /**
     * Borra una categoria de la tabla Categoria.
     * @param idCategoria el id de la categoría que se borrará.
     */
    public void deleteCategoria(int idCategoria){
        repositorioCategory.deleteById(idCategoria);
    }
}