/*
 * Creación de entidad "Cliente" y de tabla "Cliente"
 */
package com.apiReto5G7.apiReto5G7.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author J. Sebastián Beltrán
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Cliente")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idClient")
    private Integer idClient;
    
    @Column(name="email", nullable=false, length=45)
    private String email;

    @Column(name="password", nullable=false, length=45)
    private String password;
    
    @Column(name="name", nullable=false, length=250)
    private String name;
    
    @Column(name="age",nullable=false)
    private Integer age;
    
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="client")
    @JsonIgnoreProperties("client")
    private List<Mensaje> messages;
    
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="client")
    @JsonIgnoreProperties("client")
    private List<Reserva> reservations;
}
