/*
 * Creación de clase con 
 */
package com.apiReto5G7.apiReto5G7.reports;

import com.apiReto5G7.apiReto5G7.entity.Cliente;

/**
 *
 * @author J. Sebastián Beltrán.
 */
public class ReporteClientesTop {
    /**
     * Contador
     */
    private Long total;
    /**
     * Cliente
     */
    private Cliente client;

    public ReporteClientesTop(Long total, Cliente client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }
}
