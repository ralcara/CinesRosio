/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.Objects;
import jakarta.persistence.*;
import java.util.List;
/**
 *
 * @author rocio
 */
@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pelicula;

    private String titulo;
    private String genero;
    private int duracion;
    private String clasificacion;
    private String director;

    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL)
    private List<Funcion> funciones;

    public Pelicula() {
    }

    public Pelicula(int id_pelicula, String titulo, String genero, int duracion, String clasificacion, String director, List<Funcion> funciones) {
        this.id_pelicula = id_pelicula;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.director = director;
        this.funciones = funciones;
    }

    
    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List getFunciones() {
        return funciones;
    }

    public void setFunciones(List funciones) {
        this.funciones = funciones;
    }

    public Object getIdPelicula() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setIdPelicula(int idPelicula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}