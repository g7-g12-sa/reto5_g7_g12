/*
 * Creación de servicio para la ejecución de operaciones GET y POST en tabla
 * Auditorio.
 */
package com.apiReto5G7.apiReto5G7.service;

import com.apiReto5G7.apiReto5G7.entity.Auditorio;
import com.apiReto5G7.apiReto5G7.repository.AuditorioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author J. Sebastián Beltrán
 */
@Service
public class AuditorioService {
    @Autowired
    private AuditorioRepository repositorioAud;
    
    /**
     * Devuelve una lista con los registros de la tabla auditorio.
     * @return la lista con los objetos Auditorio de la tabla auditorio.
     */
    public List<Auditorio> getAllAuditorios(){
        return repositorioAud.findAll();
    }
    
    /**
     * Recupera un auditorio específico de la tabla Auditorio.
     * @param idAuditorio el id del objeto que se recuperará.
     * @return el objeto Auditorio si existe.
     */
    public Optional<Auditorio> getAuditorio(int idAuditorio){
        return repositorioAud.findById(idAuditorio);
    }
    
    /**
     * Crea un nuevo auditorio en la tabla auditorio si no existe ya.
     * @param auditorio el auditorio que se creará.
     * @return un objeto Auditorio
     */
    public Auditorio saveAuditorio(Auditorio auditorio){
        /**
         * Si auditorio no tiene ID, guardarlo.
         */
        if(auditorio.getId()==null){
            return repositorioAud.save(auditorio);        
        } else {
            /**
             * Busca el auditorio por el ID, si lo encuentra, lo guarda en
             * existeAud.
             */
            Optional<Auditorio> existeAud = getAuditorio(auditorio.getId());
            /**
             * Si existeAud está vacío, guardar auditorio. Si no, devolver
             * auditorio.
             */
            if(existeAud.isEmpty()){
                return repositorioAud.save(auditorio);
            } else {
                return auditorio;
            }
        }
    }
    
    /**
     * Actualiza los valores de un auditorio en la tabla Auditorio.
     * @param auditorio el auditorio con los valores a actualizar.
     * @return el objeto auditorio actualizado.
     */
    public Auditorio updateAuditorio(Auditorio auditorio){
        /**
         * Verificar que el objeto auditorio recibido tenga un ID.
         */
        if (auditorio.getId()!=null){
            /**
             * Verificar la existencia del objeto en BD.
             */
            Optional<Auditorio> existeAud = getAuditorio(auditorio.getId());
            /**
             * Si el objeto existe en la BD, editarlo. Si no,retornarlo como
             * está.
             */
            if (!existeAud.isEmpty()){
                /**
                 * Si el objeto auditorio tiene un valor nombre, asignarlo a
                 * existeAud.
                 */
                if (auditorio.getName()!=null){
                    existeAud.get().setName(auditorio.getName());
                }
                /**
                 * Si el objeto auditorio tiene un valor owner, asignarlo a
                 * existeAud.
                 */
                if (auditorio.getOwner()!=null){
                    existeAud.get().setOwner(auditorio.getOwner());
                }
                /**
                 * Si el objeto auditorio tiene un valor capacity, asignarlo a
                 * existeAud.
                 */
                if (auditorio.getCapacity()!=null){
                    existeAud.get().setCapacity(auditorio.getCapacity());
                }
                /**
                 * Si el objeto auditorio tiene un valor description, asignarlo
                 * a existeAud.
                 */
                if (auditorio.getDescription()!=null){
                    existeAud.get().setDescription(auditorio.getDescription());
                }
                /**
                 * Si el objeto auditorio tiene un valor category, asignarlo
                 * a existeAud.
                 */
                if (auditorio.getCategory()!=null){
                    existeAud.get().setCategory(auditorio.getCategory());
                }
                /**
                 * Devolver existeAud con valores ajustados.
                 */
                return repositorioAud.save(existeAud.get());
            } else {
                return auditorio;
            }
        } else {
            return auditorio;
        }
    }
    
    /**
     * Borra un auditorio de la tabla Auditorio.
     * @param idAuditorio el id del auditorio que se borrará.
     */
    public void deleteAuditorio(int idAuditorio){
        repositorioAud.deleteById(idAuditorio);
    }
}