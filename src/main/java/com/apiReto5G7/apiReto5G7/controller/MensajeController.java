/*
 * Creación de API /Message/ con peticiones GET, POST, PUT y DELETE.
 */
package com.apiReto5G7.apiReto5G7.controller;

import com.apiReto5G7.apiReto5G7.entity.Mensaje;
import com.apiReto5G7.apiReto5G7.service.MensajeService;
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
@RequestMapping("/api/Message")
public class MensajeController {
    /**
     * Instancear el servicio de Mensaje.
     */
    @Autowired
    private MensajeService servicioMensaje;
    
    /**
     * Petición GET para API Message.
     * @return lista de mensajes encontrados.
     */
    @GetMapping("/all")
    public List <Mensaje> getAllMensajes(){
        return servicioMensaje.getAllMensajes();
    }
    
    /**
     * Petición POST para API Message.
     * @param mensaje el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PostMapping("/save")
    public ResponseEntity saveMensaje(@RequestBody Mensaje mensaje){
        servicioMensaje.saveMensaje(mensaje);
        
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Petición PUT para API Message.
     * @param mensaje el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PutMapping("/update")
    public ResponseEntity updateMensaje(@RequestBody Mensaje mensaje){
        servicioMensaje.updateMensaje(mensaje);
        
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Petición DELETE para API Message.
     * @param idMensaje el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteMensaje(@PathVariable("id") int idMensaje){
        servicioMensaje.deleteMensaje(idMensaje);
        
        return ResponseEntity.status(204).build();
    }
}