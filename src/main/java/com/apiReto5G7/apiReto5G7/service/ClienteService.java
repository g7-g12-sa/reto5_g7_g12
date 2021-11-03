/*
 * Creación de servicio para la ejecución de operaciones GET y POST en tabla
 * Cliente.
 */
package com.apiReto5G7.apiReto5G7.service;

import com.apiReto5G7.apiReto5G7.entity.Cliente;
import com.apiReto5G7.apiReto5G7.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author J. Sebastián Beltrán
 */
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repositorioCliente;
    
    /**
     * Devuelve una lista con los registros de la tabla Cliente.
     * @return la lista con los objetos Cliente de la tabla Cliente.
     */
    public List<Cliente> getAllClientes(){
        return repositorioCliente.findAll();
    }
    
    /**
     * Recupera un cliente específica de la tabla Cliente.
     * @param idCliente el id del objeto que se recuperará.
     * @return el objeto Cliente si existe.
     */
    public Optional<Cliente> getCliente(int idCliente){
        return repositorioCliente.findById(idCliente);
    }
    
    /**
     * Crea un nuevo cliente en la tabla Cliente si no existe ya.
     * @param cliente el cliente que se creará.
     * @return el objeto Cliente creado.
     */
    public Cliente saveCliente(Cliente cliente){
        /**
         * Si cliente no tiene ID, guardarlo.
         */
        if(cliente.getIdClient()==null){
            return repositorioCliente.save(cliente);        
        } else {
            /**
             * Busca el cliente por el ID, si lo encuentra, lo guarda en
             * existeCliente.
             */
            Optional<Cliente> existeCliente = getCliente(cliente.getIdClient());
            /**
             * Si existeCliente está vacío, guardar cliente. Si no, devolver
             * cliente.
             */
            if(existeCliente.isEmpty()){
                return repositorioCliente.save(cliente);
            } else {
                return cliente;
            }
        }
    }
    
    /**
     * Actualiza los valores de un cliente en la tabla Cliente.
     * @param cliente el cliente con los valores a actualizar.
     * @return el objeto cliente actualizado.
     */
    public Cliente updateCliente(Cliente cliente){
        /**
         * Verificar que el objeto auditorio recibido tenga un ID.
         */
        if (cliente.getIdClient()!=null){
            /**
             * Verificar la existencia del objeto en BD.
             */
            Optional<Cliente> existeCliente = getCliente(cliente.getIdClient());
            /**
             * Si el objeto existe en la BD, editarlo. Si no,retornarlo como
             * está.
             */
            if (!existeCliente.isEmpty()){
                /**
                 * Si el objeto cliente tiene un valor email, asignarlo a
                 * existeCliente.
                 */
                if (cliente.getEmail()!=null){
                    existeCliente.get().setEmail(cliente.getEmail());
                }
                /**
                 * Si el objeto cliente tiene un valor password, asignarlo a
                 * existeCliente.
                 */
                if (cliente.getPassword()!=null){
                    existeCliente.get().setPassword(cliente.getPassword());
                }
                /**
                 * Si el objeto cliente tiene un valor name, asignarlo a
                 * existeCliente.
                 */
                if (cliente.getName()!=null){
                    existeCliente.get().setName(cliente.getName());
                }
                /**
                 * Si el objeto cliente tiene un valor age, asignarlo
                 * a existeCliente.
                 */
                if (cliente.getAge()!=null){
                    existeCliente.get().setAge(cliente.getAge());
                }
                /**
                 * Devolver existeCliente con valores ajustados.
                 */
                return repositorioCliente.save(existeCliente.get());
            } else {
                return cliente;
            }
        } else {
            return cliente;
        }
    }
    
    /**
     * Borra un cliente de la tabla Cliente.
     * @param idCliente el id del cliente que se borrará.
     */
    public void deleteCliente(int idCliente){
        repositorioCliente.deleteById(idCliente);
    }
}