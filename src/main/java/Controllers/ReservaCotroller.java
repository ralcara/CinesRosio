/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Modelos.Reserva;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author rocio
 */
public class ReservaCotroller {
    
    public List<Reserva> obtenerTodas() {
    EntityManager em = JPA.getEntityManager();
    try {
        return em.createQuery("SELECT r FROM Reserva r", Reserva.class).getResultList();
    } finally {
        em.close();
    }
}
     public void crearReserva(Reserva reserva) {
        EntityManager em = JPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(reserva);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Reserva buscarReserva(int id) {
        EntityManager em = JPA.getEntityManager();
        try {
            return em.find(Reserva.class, id);
        } finally {
            em.close();
        }
    }

    public void actualizarReserva(Reserva reserva) {
        EntityManager em = JPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(reserva);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminarReserva(int id) {
        EntityManager em = JPA.getEntityManager();
        try {
            Reserva reserva = em.find(Reserva.class, id);
            if (reserva != null) {
                em.getTransaction().begin();
                em.remove(reserva);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
    }
}

