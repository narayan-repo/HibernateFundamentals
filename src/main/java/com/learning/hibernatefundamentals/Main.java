package com.learning.hibernatefundamentals;

import com.learning.hibernatefundamentals.airport.Airport;
import com.learning.hibernatefundamentals.airport.Passenger;
import com.learning.hibernatefundamentals.airport.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory enf = Persistence.createEntityManagerFactory("airport");
        EntityManager en = enf.createEntityManager();

        en.getTransaction().begin();

        Airport airport = new Airport(1, "Henri Coanda");
        Passenger john = new Passenger(1, "John Smith");
        john.setAirport(airport);

        Passenger mike = new Passenger(2, "Michael Johnson");
        mike.setAirport(airport);

        airport.addPassenger(john);
        airport.addPassenger(mike);

        Ticket ticket1 = new Ticket(1, "AA1234");
        Ticket ticket2 = new Ticket(2, "BB5678");

        john.addTicket(ticket1);
        john.addTicket(ticket2);

        ticket1.setPassenger(john);
        ticket2.setPassenger(john);

        Ticket ticket3 = new Ticket(3, "CC0987");
        mike.addTicket(ticket3);

        ticket3.setPassenger(mike);

        en.persist(airport);
        en.persist(john);
        en.persist(mike);
        en.persist(ticket1);
        en.persist(ticket2);
        en.persist(ticket3);

        en.getTransaction().commit();
        enf.close();
    }
}
