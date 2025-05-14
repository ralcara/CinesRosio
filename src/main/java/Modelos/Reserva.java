/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.Date;

/**
 *
 * @author rocio
 */
public class Reserva {

    private int id;
    private int idFuncion;
    private int idCliente;
    private int numAsientos;
    private Date fechaReserva;

    public Reserva(int id, int idFuncion, int idCliente, int numAsientos, Date fechaReserva) {
        this.id = id;
        this.idFuncion = idFuncion;
        this.idCliente = idCliente;
        this.numAsientos = numAsientos;
        this.fechaReserva = fechaReserva;
    }

    public Reserva(int idFuncion, int idCliente, int numAsientos, Date fechaReserva) {
        this(0, idFuncion, idCliente, numAsientos, fechaReserva);
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getNumAsientos() {
        return numAsientos;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNumAsientos(int numAsientos) {
        this.numAsientos = numAsientos;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
}
