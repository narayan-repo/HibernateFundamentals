package com.learning.hibernatefundamentals.airport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("airport");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Passenger passenger = new Passenger(1, "Narayan Maity", "Medinipur");
        em.persist(passenger);

        em.getTransaction().commit();
    }
}
