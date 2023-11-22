package ua.homework.Client;


import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.homework.hibernate.HibernateUntil;

import java.util.List;

public class ClientCrudService {

    public void createClient(Client client) {
        if (client.getName() == null) {
            throw new IllegalArgumentException("Name cannot be null!");
        } else if (client.getName().length() < 3 || client.getName().length() > 200) {
            throw new IllegalArgumentException("Name cannot be less than 3 characters or more than 200 characters");
        }
        try (Session session = HibernateUntil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }
    }

    public Client getById(long id) {
        try (Session session = HibernateUntil.getInstance().getSessionFactory().openSession()) {
            return session.get(Client.class, id);
        }
    }

    public void setName(long id, String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null!");
        } else if (name.length() < 3 || name.length() > 200) {
            throw new IllegalArgumentException("Name cannot be less than 3 characters or more than 200 characters");
        }
        try (Session session = HibernateUntil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Client existing = session.get(Client.class, id);
            existing.setName(name);
            session.update(existing);
            transaction.commit();
        }
    }

    public void deleteById(long id) {
        try (Session session = HibernateUntil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            if (client != null) {
                session.delete(client);
            }
            transaction.commit();
        }
    }


    public List<Client> listAllClients() {
        try (Session session = HibernateUntil.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("from Client", Client.class).list();
        }
    }
}