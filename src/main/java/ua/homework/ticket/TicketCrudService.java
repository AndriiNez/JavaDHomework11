package ua.homework.ticket;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.homework.checks.CheckIsUpperCaseAndDigit;
import ua.homework.hibernate.HibernateUntil;

import java.util.List;

public class TicketCrudService {
    private CheckIsUpperCaseAndDigit checkIsUpperCaseAndDigit = new CheckIsUpperCaseAndDigit();

    public void create(Ticket ticket) {
        if (ticket.getClient() == null || ticket.getClient().getId() == 0) {
            throw new IllegalArgumentException("Cannot save ticket for a non-existing or null client");
        }

        if (ticket.getFromPlanet() == null || ticket.getToPlanet() == null) {
            throw new IllegalArgumentException("Cannot save ticket for non-existing or null planet");
        } else if (checkIsUpperCaseAndDigit.isUpperCaseAndDigit(String.valueOf(ticket.getFromPlanet())) || checkIsUpperCaseAndDigit.isUpperCaseAndDigit(String.valueOf(ticket.getToPlanet()))) {
            throw new IllegalArgumentException("The string must consist exclusively of uppercase Latin letters and numbers");
        }

        try (Session session = HibernateUntil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
        }
    }

    public Ticket getById(Long id) {
        try (Session session = HibernateUntil.getInstance().getSessionFactory().openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    public void update(Ticket ticket) {
        try (Session session = HibernateUntil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(ticket);
            transaction.commit();
        }
    }

    public void deleteById(Long id) {
        try (Session session = HibernateUntil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            if (ticket != null) {
                session.delete(ticket);
            }
            transaction.commit();
        }
    }


    public List<Ticket> listAllTickets() {
        try (Session session = HibernateUntil.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("from Ticket", Ticket.class).list();
        }
    }
}
