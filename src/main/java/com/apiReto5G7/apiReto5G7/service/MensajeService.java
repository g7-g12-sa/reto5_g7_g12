/*
 * Creación de servicio para la ejecución de operaciones GET y POST en tabla
 * Mensaje.
 */
package com.apiReto5G7.apiReto5G7.service;

import com.apiReto5G7.apiReto5G7.entity.Mensaje;
import com.apiReto5G7.apiReto5G7.repository.MensajeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author J. Sebastián Beltrán
 */
@Service
public class MensajeService {
    @Autowired
    private MensajeRepository repositorioMensaje;
    
    /**
     * Devuelve una lista con los registros de la tabla Mensaje.
     * @return la lista con los objetos Mensaje de la tabla Mensaje.
     */
    public List<Mensaje> getAllMensajes(){
        return repositorioMensaje.findAll();
    }
    
    /**
     * Recupera un mensaje específica de la tabla Mensaje.
     * @param idMensaje el id del objeto que se recuperará.
     * @return el objeto Mensaje si existe.
     */
    public Optional<Mensaje> getMensaje(int idMensaje){
        return repositorioMensaje.findById(idMensaje);
    }
    
    /**
     * Crea un nuevo mensaje en la tabla Mensaje si no existe ya.
     * @param mensaje el mensaje que se creará.
     * @return el objeto Mensaje creado.
     */
    public Mensaje saveMensaje(Mensaje mensaje){
        /**
         * Si mensaje no tiene ID, guardarlo.
         */
        if(mensaje.getIdMessage()==null){
            return repositorioMensaje.save(mensaje);        
        } else {
            /**
             * Busca el mensaje por el ID, si lo encuentra, lo guarda en
             * existeMen.
             */
            Optional<Mensaje> existeMen = getMensaje(mensaje.getIdMessage());
            /**
             * Si existeMen está vacío, guardar mensaje. Si no, devolver
             * mensaje.
             */
            if(existeMen.isEmpty()){
                return repositorioMensaje.save(mensaje);
            } else {
                return mensaje;
            }
        }
    }
    
    /**
     * Actualiza los valores de un mensaje en la tabla Mensaje.
     * @param mensaje el mensaje con los valores a actualizar.
     * @return el objeto mensaje actualizado.
     */
    public Mensaje updateMensaje(Mensaje mensaje){
        /**
         * Verificar que el objeto auditorio recibido tenga un ID.
         */
        if (mensaje.getIdMessage()!=null){
            /**
             * Verificar la existencia del objeto en BD.
             */
            Optional<Mensaje> existeMen = getMensaje(mensaje.getIdMessage());
            /**
             * Si el objeto existe en la BD, editarlo. Si no,retornarlo como
             * está.
             */
            if (!existeMen.isEmpty()){
                /**
                 * Si el objeto mensaje tiene un valor messageText, asignarlo a
                 * existeMen.
                 */
                if (mensaje.getMessageText()!=null){
                    existeMen.get().setMessageText(mensaje.getMessageText());
                }
                /**
                 * Si el objeto mensaje tiene un valor audience, asignarlo a
                 * existeMen.
                 */
                if (mensaje.getAudience()!=null){
                    existeMen.get().setAudience(mensaje.getAudience());
                }
                /**
                 * Si el objeto mensaje tiene un valor client, asignarlo a
                 * existeMen.
                 */
                if (mensaje.getClient()!=null){
                    existeMen.get().setClient(mensaje.getClient());
                }
                /**
                 * Devolver existeMen con valores ajustados.
                 */
                return repositorioMensaje.save(existeMen.get());
            } else {
                return mensaje;
            }
        } else {
            return mensaje;
        }
    }
    
    /**
     * Borra un mensaje de la tabla Mensaje.
     * @param idMensaje el id del mensaje que se borrará.
     */
    public void deleteMensaje(int idMensaje){
        repositorioMensaje.deleteById(idMensaje);
    }
}