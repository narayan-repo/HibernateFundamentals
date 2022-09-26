package com.learning.hibernatefundamentals.airport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("airport");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        Passenger passenger;
        int idCount = 1;
        boolean flag = true;
        while(flag) {
            System.out.println("----Menu----");
            System.out.println("1. Enter passenger details");
            System.out.println("2. Exit\n");
            int option;
            try {
                System.out.print("Enter option: ");
                option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1 -> {
                        System.out.print("Enter name:\t");
                        String name = scanner.nextLine();

                        System.out.print("Enter street:\t");
                        String street = scanner.nextLine();

                        System.out.print("Enter number:\t");
                        String number = scanner.nextLine();

                        System.out.print("Enter zipCode:\t");
                        String zipCode = scanner.nextLine();

                        System.out.print("Enter city:\t");
                        String city = scanner.nextLine();

                        passenger = new Passenger(idCount++, name);
                        passenger.setCity(city);
                        passenger.setNumber(number);
                        passenger.setStreet(street);
                        passenger.setZipCode(zipCode);

                        em.persist(passenger);
                    }
                    case 2 -> {
                        em.getTransaction().commit();
                        flag = false;
                    }
                    default -> System.out.println("Wrong option selected.\nPlease try again.");
                }
            } catch(InputMismatchException e){
                flag = false;
                System.out.println("Invalid Option");
                System.out.println("Transaction Cancelled");
            } catch (Exception e) {
                flag = false;
                e.printStackTrace();
            }
        }
        em.close();
    }
}
