/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Modelos.Cliente;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author rocio
 */
public class ClienteController {

    public List<Cliente> listarClientes() {
    EntityManager em = JPA.getEntityManager();
    try {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    } finally {
        em.close();
    }
}
    public void crearCliente(Cliente cliente) {
        EntityManager em = JPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Cliente buscarCliente(int id) {
        EntityManager em = JPA.getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public void actualizarCliente(Cliente cliente) {
        EntityManager em = JPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminarCliente(int id) {
        EntityManager em = JPA.getEntityManager();
        try {
            Cliente cliente = em.find(Cliente.class, id);
            if (cliente != null) {
                em.getTransaction().begin();
                em.remove(cliente);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
    }
}


