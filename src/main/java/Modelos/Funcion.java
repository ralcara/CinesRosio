/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author rocio
 */
public class Funcion {

    private int id;
    private int idPelicula;
    private Date fecha;
    private Time hora;
    private int sala;

    public Funcion(int id, int idPelicula, Date fecha, Time hora, int sala) {
        this.id = id;
        this.idPelicula = idPelicula;
        this.fecha = fecha;
        this.hora = hora;
        this.sala = sala;
    }

    public Funcion(int idPelicula, Date fecha, Time hora, int sala) {
        this(0, idPelicula, fecha, hora, sala);
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHora() {
        return hora;
    }

    public int getSala() {
        return sala;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }
}
