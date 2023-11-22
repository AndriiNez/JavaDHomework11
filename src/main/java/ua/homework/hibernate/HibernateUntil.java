package ua.homework.hibernate;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.homework.Client.Client;
import ua.homework.planet.Planet;
import ua.homework.ticket.Ticket;


public class HibernateUntil {
    private static final HibernateUntil INSTANCE;

    @Getter
    private final SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUntil();
    }

    private HibernateUntil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    public static HibernateUntil getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }

}

