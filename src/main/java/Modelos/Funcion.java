/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author rocio
 */

@Entity
public class Funcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_funcion;

    @ManyToOne
    @JoinColumn(name = "id_pelicula")
    private Pelicula pelicula;

    private LocalDate fecha;
    private LocalTime hora;
    private int sala;

    @OneToMany(mappedBy = "funcion", cascade = CascadeType.ALL)
    private List<Reserva> reservas;

    public Funcion(LocalDate fecha, Pelicula pelicula, LocalTime hora, int sala) {
        this.fecha = fecha;
        this.pelicula = pelicula;
        this.hora = hora;
        this.sala = sala;
    }

    public Funcion(int id_funcion, Pelicula pelicula, LocalDate fecha, LocalTime hora, int sala, List<Reserva> reservas) {
        this.id_funcion = id_funcion;
        this.pelicula = pelicula;
        this.fecha = fecha;
        this.hora = hora;
        this.sala = sala;
        this.reservas = reservas;
    }

    public int getId_funcion() {
        return id_funcion;
    }

    public void setId_funcion(int id_funcion) {
        this.id_funcion = id_funcion;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return getPelicula() + ", " + getFecha() + ", " + getHora() + ", Sala: " + getSala();
    }

}
