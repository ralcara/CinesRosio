/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author rocio
 */
public class JPA {

    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("CinesRosioPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
