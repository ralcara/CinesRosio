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
@Table(name = "funcion")
public class Funcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_funcion;

    @ManyToOne
    @JoinColumn(name = "id_pelicula", nullable = false)
    private Pelicula pelicula;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @Column(name = "sala")
    private String sala;

    @OneToMany(mappedBy = "funcion", cascade = CascadeType.ALL)
    private List<Reserva> reservas;

    public Funcion() {
    }

    public Funcion(Pelicula pelicula, LocalDate fecha, LocalTime hora, String sala, List<Reserva> reservas) {
        this.pelicula = pelicula;
        this.fecha = fecha;
        this.hora = hora;
        this.sala = sala;
        this.reservas = reservas;
    }

    public Funcion(LocalDate fecha, Pelicula pelicula, LocalTime hora, String sala) {
        this.fecha = fecha;
        this.pelicula = pelicula;
        this.hora = hora;
        this.sala = sala;
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

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
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
        return "Funcion{" +
                "id_funcion=" + id_funcion +
                ", pelicula=" + pelicula +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", sala='" + sala + '\'' +
                '}';
    }
}
