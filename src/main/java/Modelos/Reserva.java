/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import jakarta.persistence.*;
import java.time.LocalDate;
/**
 *
 * @author rocio
 */


@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reserva;

    @ManyToOne
    @JoinColumn(name = "id_funcion")
    private Funcion funcion;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    private int num_asientos;
    private LocalDate fecha_reserva;

    public Reserva() {
    }

    public Reserva(int id_reserva, Funcion funcion, Cliente cliente, int num_asientos, LocalDate fecha_reserva) {
        this.id_reserva = id_reserva;
        this.funcion = funcion;
        this.cliente = cliente;
        this.num_asientos = num_asientos;
        this.fecha_reserva = fecha_reserva;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNum_asientos() {
        return num_asientos;
    }

    public void setNum_asientos(int num_asientos) {
        this.num_asientos = num_asientos;
    }

    public LocalDate getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(LocalDate fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }
@Override
public String toString() {
    return "Reserva ID: " + id_reserva + 
           ", Función: " + (funcion != null ? funcion.getId_funcion(): "N/A") + 
           ", Cliente: " + (cliente != null ? cliente.getNombre() : "N/A") + 
           ", Asientos: " + num_asientos + 
           ", Fecha: " + fecha_reserva;
}
  
}