package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        // Creating Car object
        Car car = new Car();
        car.setName("Sedan");
        car.setType("Car");
        car.setMaxSpeed(180);
        car.setColor("Red");
        car.setNumberOfDoors(4);

        // Creating Truck object
        Truck truck = new Truck();
        truck.setName("Freightliner");
        truck.setType("Truck");
        truck.setMaxSpeed(120);
        truck.setColor("Blue");
        truck.setLoadCapacity(5000);

        // Persisting objects
        session.persist(car);
        session.persist(truck);

        transaction.commit();
        session.close();

        System.out.println("Records inserted successfully!");
    }
}
