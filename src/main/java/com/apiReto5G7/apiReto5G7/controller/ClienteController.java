/*
 * Creación de API /Client/ con peticiones GET y POST.
 */
package com.apiReto5G7.apiReto5G7.controller;

import com.apiReto5G7.apiReto5G7.entity.Cliente;
import com.apiReto5G7.apiReto5G7.service.ClienteService;
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
@RequestMapping("/api/Client")
public class ClienteController {
    /**
     * Instancear el servicio de Cliente.
     */
    @Autowired
    private ClienteService servicioCliente;
    
    /**
     * Petición GET para API Client.
     * @return lista de clientes encontrados.
     */
    @GetMapping("/all")
    public List <Cliente> getAllClientes(){
        return servicioCliente.getAllClientes();
    }
    
    /**
     * Petición POST para API Client.
     * @param cliente el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PostMapping("/save")
    public ResponseEntity saveCliente(@RequestBody Cliente cliente){
        servicioCliente.saveCliente(cliente);
        
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Petición PUT para API Client.
     * @param cliente el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (201).
     */
    @PutMapping("/update")
    public ResponseEntity updateCliente(@RequestBody Cliente cliente){
        servicioCliente.updateCliente(cliente);
        
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Petición DELETE para API Client.
     * @param idCliente el objeto Json que se enviará.
     * @return código de estado de respuesta HTTP (204).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCliente(@PathVariable("id") int idCliente){
        servicioCliente.deleteCliente(idCliente);
        
        return ResponseEntity.status(204).build();
    }
}