/*
 * Creación de servicio para la ejecución de operaciones GET y POST en tabla
 * Calificacion.
 */
package com.apiReto5G7.apiReto5G7.service;

import com.apiReto5G7.apiReto5G7.entity.Calificacion;
import com.apiReto5G7.apiReto5G7.repository.CalificacionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author J. Sebastián Beltrán
 */
@Service
public class CalificacionService {
    @Autowired
    private CalificacionRepository repositorioCalif;
    
    /**
     * Devuelve una lista con los registros de la tabla Calificacion.
     * @return la lista con los objetos Calificacion de la tabla Calificacion.
     */
    public List<Calificacion> getAllCalificaciones(){
        return repositorioCalif.findAll();
    }
    
    /**
     * Recupera una calificacion específico de la tabla Calificacion.
     * @param idCalificacion el id del objeto que se recuperará.
     * @return el objeto Calificacion si existe.
     */
    public Optional<Calificacion> getCalificacion(int idCalificacion){
        return repositorioCalif.findById(idCalificacion);
    }
    
    /**
     * Crea una nueva calificación en la tabla Calificacion si no existe ya.
     * @param calificacion la calificación que se creará.
     * @return el objeto Calificacion creado.
     */
    public Calificacion saveCalificacion(Calificacion calificacion){
        /**
         * Si calificacion no tiene ID, guardarlo.
         */
        if(calificacion.getId()==null){
            return repositorioCalif.save(calificacion);        
        } else {
            /**
             * Busca el calificacion por el ID, si lo encuentra, lo guarda en
             * existeCalif.
             */
            Optional<Calificacion> existeCalif = getCalificacion(
                                                 calificacion.getId());
            /**
             * Si existeCalif está vacío, guardar calificacion. Si no, devolver
             * calificacion.
             */
            if(existeCalif.isEmpty()){
                return repositorioCalif.save(calificacion);
            } else {
                return calificacion;
            }
        }
    }
    
    /**
     * Actualiza los valores de una calificación en la tabla Calificacion.
     * @param calificacion la calificación con los valores a actualizar.
     * @return el objeto calificacion actualizado.
     */
    public Calificacion updateCalificacion(Calificacion calificacion){
        /**
         * Verificar que el objeto auditorio recibido tenga un ID.
         */
        if (calificacion.getId()!=null){
            /**
             * Verificar la existencia del objeto en BD.
             */
            Optional<Calificacion> existeCalif = getCalificacion(
                                                 calificacion.getId());
            /**
             * Si el objeto existe en la BD, editarlo. Si no,retornarlo como
             * está.
             */
            if (!existeCalif.isEmpty()){
                /**
                 * Si el objeto calificacion tiene un valor score, asignarlo a
                 * existeCalif.
                 */
                if (calificacion.getScore()!=null){
                    existeCalif.get().setScore(calificacion.getScore());
                }
                /**
                 * Si el objeto calificacion tiene un valor Message, asignarlo a
                 * existeCalif.
                 */
                if (calificacion.getMessage()!=null){
                    existeCalif.get().setMessage(calificacion.getMessage());
                }
                /**
                 * Si el objeto calificacion tiene un valor reservation,
                 * asignarlo a existeCalif.
                 */
                if (calificacion.getReservation()!=null){
                    existeCalif.get().setReservation(calificacion.getReservation());
                }
                /**
                 * Devolver existeCalif con valores ajustados.
                 */
                return repositorioCalif.save(existeCalif.get());
            } else {
                return calificacion;
            }
        } else {
            return calificacion;
        }
    }
    
    /**
     * Borra una calificación de la tabla Calificacion.
     * @param idCalificacion el id de la calificacion que se borrará.
     */
    public void deleteCalificacion(int idCalificacion){
        repositorioCalif.deleteById(idCalificacion);
    }
}