/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.Objects;

/**
 *
 * @author rocio
 */
public class Pelicula {

    private int id;
    private String titulo;
    private String genero;
    private int duracion;
    private String clasificacion;
    private String director;

    public Pelicula(int id, String titulo, String genero, int duracion, String clasificacion, String director) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.director = director;
    }

    public Pelicula(String titulo, String genero, int duracion, String clasificacion, String director) {
        this(0, titulo, genero, duracion, clasificacion, director);
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public String getDirector() {
        return director;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.titulo);
        hash = 79 * hash + Objects.hashCode(this.genero);
        hash = 79 * hash + this.duracion;
        hash = 79 * hash + Objects.hashCode(this.clasificacion);
        hash = 79 * hash + Objects.hashCode(this.director);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pelicula other = (Pelicula) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.duracion != other.duracion) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        if (!Objects.equals(this.clasificacion, other.clasificacion)) {
            return false;
        }
        return Objects.equals(this.director, other.director);
    }

    @Override
    public String toString() {
        return "Pelicula{" + "id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", duracion=" + duracion + ", clasificacion=" + clasificacion + ", director=" + director + '}';
    }
    
}
