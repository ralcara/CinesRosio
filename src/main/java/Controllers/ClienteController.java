package Controllers;

import Modelos.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

/**
 * Controlador para gestionar las operaciones CRUD de la entidad Cliente.
 * 
 * @author rocio
 */
public class ClienteController {

    /**
     * Lista todos los clientes almacenados en la base de datos.
     * 
     * @return Lista de objetos Cliente.
     */
    public List<Cliente> listarClientes() {
        EntityManager em = JPA.getEntityManager(); //conectarse a la base de datos
        try {
            // Consulta para todos los clientes
            return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        } finally {
            em.close(); 
        }
    }

    /**
     * Crea un nuevo cliente en la base de datos.
     * 
     * @param cliente Objeto Cliente a guardar.
     */
    public void crearCliente(Cliente cliente) {
        EntityManager em = JPA.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();      // Iniciar la transacción
            em.persist(cliente);      // Guardar el cliente
            transaction.commit();     // Confirmar los cambios
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // En caso de error, revertir cambios
            }
            throw e; 
        } finally {
            em.close(); 
        }
    }

    /**
     * Busca un cliente por su ID.
     * 
     * @param id Identificador del cliente.
     * @return Cliente encontrado o null si no existe.
     */
    public Cliente buscarCliente(int id) {
        EntityManager em = JPA.getEntityManager();
        try {
            return em.find(Cliente.class, id);  // Buscar cliente por clave primaria
        } finally {
            em.close();
        }
    }

    /**
     * Actualiza los datos de un cliente existente.
     * 
     * @param cliente Cliente con los datos actualizados.
     */
    public void actualizarCliente(Cliente cliente) {
        EntityManager em = JPA.getEntityManager();
        try {
            em.getTransaction().begin();  // Iniciar transacción
            em.merge(cliente);            // Actualizar cliente
            em.getTransaction().commit(); // Confirmar cambios
        } finally {
            em.close();
        }
    }

    /**
     * Elimina un cliente por su ID.
     * 
     * @param id Identificador del cliente a eliminar.
     */
    public void eliminarCliente(int id) {
        EntityManager em = JPA.getEntityManager();
        try {
            Cliente cliente = em.find(Cliente.class, id); // Buscar cliente por ID
            if (cliente != null) {
                em.getTransaction().begin();  // Iniciar transacción
                em.remove(cliente);            // Eliminar cliente
                em.getTransaction().commit(); // Confirmar eliminación
            }
            // Si no se encuentra el cliente, no se hace na
        } finally {
            em.close(); 
        }
    }
}
