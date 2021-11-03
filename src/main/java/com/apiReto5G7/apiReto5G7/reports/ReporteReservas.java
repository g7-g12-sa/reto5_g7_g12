/*
 * Creación de clase con la cuenta de reservas completadas y canceladas.
 */
package com.apiReto5G7.apiReto5G7.reports;

/**
 *
 * @author J. Sebastián Beltrán.
 */
public class ReporteReservas {
    /**
     * Número de reservas completadas.
     */
    private int completed;
    /**
     * Número de reservas canceladas.
     */
    private int cancelled;

    public ReporteReservas(int completed, int cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }

    
}
