/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Modelos.Pelicula;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author rocio
 */
public class PeliculaController {

    public List<Pelicula> listarPeliculas() {
    EntityManager em = JPA.getEntityManager();
    try {
        return em.createQuery("SELECT p FROM Pelicula p", Pelicula.class).getResultList();
    } finally {
        em.close();
    }
}
    
    public void crearPelicula(Pelicula pelicula) {
        EntityManager em = JPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(pelicula);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Pelicula buscarPelicula(int id) {
        EntityManager em = JPA.getEntityManager();
        try {
            return em.find(Pelicula.class, id);
        } finally {
            em.close();
        }
    }

    public void actualizarPelicula(Pelicula pelicula) {
        EntityManager em = JPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(pelicula);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminarPelicula(int id) {
        EntityManager em = JPA.getEntityManager();
        try {
            Pelicula pelicula = em.find(Pelicula.class, id);
            if (pelicula != null) {
                em.getTransaction().begin();
                em.remove(pelicula);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
    }
     public static Pelicula buscarPorId(int id) {
        EntityManager em = null;
        Pelicula pelicula = null;
        try {
            em = JPA.getEntityManager();
            pelicula = em.find(Pelicula.class, id);
        } catch (Exception e) {
            System.err.println("Error al buscar película: " + e.getMessage());
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return pelicula;
    }
}
}
