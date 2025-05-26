/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Modelos.Funcion;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author rocio
 */
public class FuncionController {
 
    public void crearFuncion(Funcion funcion) {
        EntityManager em = JPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(funcion);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Funcion buscarFuncion(int id) {
        EntityManager em = JPA.getEntityManager();
        try {
            return em.find(Funcion.class, id);
        } finally {
            em.close();
        }
    }

    public void actualizarFuncion(Funcion funcion) {
        EntityManager em = JPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(funcion);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminarFuncion(int id) {
        EntityManager em = JPA.getEntityManager();
        try {
            Funcion funcion = em.find(Funcion.class, id);
            if (funcion != null) {
                em.getTransaction().begin();
                em.remove(funcion);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
    }

    public List<Funcion> listarFunciones() {
        EntityManager em = JPA.getEntityManager();
        try {
            return em.createQuery("SELECT f FROM Funcion f", Funcion.class).getResultList();
        } finally {
            em.close();
        }
    }
}