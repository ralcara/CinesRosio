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
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_reserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_funcion")
    private Funcion funcion;
    // Relación muchos a uno con la entidad Cliente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
// no puede ser nula al igual k la fecha de reserva
    @Column(name = "cantidad_boletos", nullable = false)
    private int num_asientos;

    @Column(name = "fecha_reserva", nullable = false)
    private LocalDateTime fecha_reserva;

    public Reserva() {
    }

    public Reserva(Funcion funcion, Cliente cliente, int num_asientos, LocalDateTime fecha_reserva) {
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

    public LocalDateTime getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(LocalDateTime fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    @Override
    public String toString() {
        return "Reserva{"
                + "id_reserva=" + id_reserva
                + ", funcion=" + (funcion != null ? funcion.getId_funcion() : "N/A")
                + ", cliente=" + (cliente != null ? cliente.getNombre() : "N/A")
                + ", num_asientos=" + num_asientos
                + ", fecha_reserva=" + fecha_reserva
                + '}';
    }
}
