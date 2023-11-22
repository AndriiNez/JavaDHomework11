package ua.homework.planet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.homework.checks.CheckIsUpperCaseAndDigit;
import ua.homework.hibernate.HibernateUntil;

import java.util.List;

public class PlanetCrudService {
    private CheckIsUpperCaseAndDigit checkIsUpperCaseAndDigit = new CheckIsUpperCaseAndDigit();

    public void createPlanet(Planet planet) {
        if (planet.getName() == null) {
            throw new IllegalArgumentException("Name cannot be null!");
        } else if (planet.getName().length() < 1 || planet.getName().length() > 500) {
            throw new IllegalArgumentException("Name cannot be less than 1 characters or more than 500 characters");
        }

        if (planet.getId() == null) {
            throw new IllegalArgumentException("ID cannot be null!");
        } else if (checkIsUpperCaseAndDigit.isUpperCaseAndDigit(planet.getId())) {
            throw new IllegalArgumentException("The string must consist exclusively of uppercase Latin letters and numbers");
        }

        try (Session session = HibernateUntil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        }
    }

    public Planet getById(String id) {
        try (Session session = HibernateUntil.getInstance().getSessionFactory().openSession()) {
            return session.get(Planet.class, id);
        }
    }

    public void setName(String id, String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null!");
        } else if (name.length() < 1 || name.length() > 500) {
            throw new IllegalArgumentException("Name cannot be less than 1 characters or more than 500 characters");
        }
        try (Session session = HibernateUntil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Planet existing = session.get(Planet.class, id);
            existing.setName(name);
            session.update(existing);
            transaction.commit();
        }
    }

    public void deleteById(String id) {
        try (Session session = HibernateUntil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            if (planet != null) {
                session.delete(planet);
            }
            transaction.commit();
        }
    }


    public List<Planet> listAllPlanets() {
        try (Session session = HibernateUntil.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("from Planet", Planet.class).list();
        }
    }
}


