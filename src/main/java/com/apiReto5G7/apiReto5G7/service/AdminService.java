/*
 * Creación de servicio para la ejecución de operaciones GET, POST, PUT y 
 * DELETE en tabla Admin.
 */
package com.apiReto5G7.apiReto5G7.service;

import com.apiReto5G7.apiReto5G7.entity.Admin;
import com.apiReto5G7.apiReto5G7.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author J. Sebastián Beltrán
 */
@Service
public class AdminService {
    @Autowired
    private AdminRepository repositorioAdmin;
    
    /**
     * Devuelve una lista con los registros de la tabla Administrador.
     * @return la lista con los objetos Admin de la tabla Administrador.
     */
    public List<Admin> getAllAdmins(){
        return repositorioAdmin.findAll();
    }
    
    /**
     * Recupera un administrador específico de la tabla Administrador.
     * @param idAdmin elid del objeto que se recuperará.
     * @return el objeto Admin si existe.
     */
    public Optional<Admin> getAdmin(int idAdmin){
        return repositorioAdmin.findById(idAdmin);
    }
    
    /**
     * Crea un nuevo administrador en la tabla Administrador si no existe ya.
     * @param admin el admin que se creará.
     * @return el objeto Admin creado.
     */
    public Admin saveAdmin(Admin admin){
        /**
         * Si admin no tiene ID, guardarlo.
         */
        if(admin.getId()==null){
            return repositorioAdmin.save(admin);        
        } else {
            /**
             * Busca el admin por el ID, si lo encuentra, lo guarda en
             * existeAdm.
             */
            Optional<Admin> existeAdm = getAdmin(admin.getId());
            /**
             * Si existeAdm está vacío, guardar audmin. Si no, devolver
             * admin.
             */
            if(existeAdm.isEmpty()){
                return repositorioAdmin.save(admin);
            } else {
                return admin;
            }
        }
    }
    
    /**
     * Actualiza los valores de un administrador en la tabla Administrador.
     * @param admin el admin con los valores a actualizar.
     * @return el objeto admin actualizado.
     */
    public Admin updateAdmin(Admin admin){
        /**
         * Verificar que el objeto admin recibido tenga un ID.
         */
        if (admin.getId()!=null){
            /**
             * Verificar la existencia del objeto en BD.
             */
            Optional<Admin> existeAdm = getAdmin(admin.getId());
            /**
             * Si el objeto existe en la BD, editarlo. Si no, retornarlo como
             * está.
             */
            if (!existeAdm.isEmpty()){
                /**
                 * Si el objeto admin tiene un valor nombre, asignarlo a
                 * existeAdm.
                 */
                if (admin.getName()!=null){
                    existeAdm.get().setName(admin.getName());
                }
                /**
                 * Si el objeto admin tiene un valor email, asignarlo a
                 * existeAdm.
                 */
                if (admin.getEmail()!=null){
                    existeAdm.get().setEmail(admin.getEmail());
                }
                /**
                 * Si el objeto admin tiene un valor password, asignarlo a
                 * existeAdm.
                 */
                if (admin.getPassword()!=null){
                    existeAdm.get().setPassword(admin.getPassword());
                }
                /**
                 * Devolver existeAdm con valores ajustados.
                 */
                return repositorioAdmin.save(existeAdm.get());
            } else {
                return admin;
            }
        } else {
            return admin;
        }
    }
    
    /**
     * Borra un administrador de la tabla Administrador.
     * @param idAdmin el id del administrador que se borrará.
     */
    public void deleteAdmin(int idAdmin){
        repositorioAdmin.deleteById(idAdmin);
    }
}