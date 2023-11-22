package ua.homework;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.homework.Client.Client;
import ua.homework.Client.ClientCrudService;
import ua.homework.Migrations.DatabaseMigrationsService;
import ua.homework.Migrations.RiderHibernateUrl;
import ua.homework.hibernate.HibernateUntil;
import ua.homework.planet.Planet;
import ua.homework.planet.PlanetCrudService;
import ua.homework.ticket.Ticket;
import ua.homework.ticket.TicketCrudService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        RiderHibernateUrl hibernateUrl = new RiderHibernateUrl();

        new DatabaseMigrationsService().initDbService(hibernateUrl.hibernateUrl());
        

        TicketCrudService ticketCrudService = new TicketCrudService();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Ticket newTicket = new Ticket();
        Client client = new Client();
        Planet fromPlanet = new Planet();
        Planet toPlanet = new Planet();
        client.setId(4l);
        fromPlanet.setId("MARS");
        toPlanet.setId("JUP");
        newTicket.setCreatedAt(LocalDateTime.now().format(formatter));
        newTicket.setClient(client);
        newTicket.setFromPlanet(fromPlanet);
        newTicket.setToPlanet(toPlanet);
        ticketCrudService.createTicket(newTicket);

        Ticket ticketById = ticketCrudService.getTicketById(11l);
        System.out.println("Get by id Ticket after create = " + ticketById +
                ", from Planet = " + ticketById.getFromPlanet() +
                ", to Planet = " + ticketById.getToPlanet() +
                ", Client = " + ticketById.getClient());

        Ticket updateTicket = new Ticket();
        Client clientUpdate = new Client();
        Planet fromPlanetUpdate = new Planet();
        Planet toPlanetUpdate = new Planet();
        clientUpdate.setId(4l);
        fromPlanetUpdate.setId("VEN");
        toPlanetUpdate.setId("EARTH");
        updateTicket.setCreatedAt(LocalDateTime.now().format(formatter));
        updateTicket.setClient(clientUpdate);
        updateTicket.setFromPlanet(fromPlanetUpdate);
        updateTicket.setToPlanet(toPlanetUpdate);
        updateTicket.setId(11l);
        ticketCrudService.updateTicket(updateTicket);

        Ticket ticketByIdUpdate = ticketCrudService.getTicketById(11l);
        System.out.println("Get by id Ticket after updete = " + ticketByIdUpdate +
                ", from Planet = " + ticketByIdUpdate.getFromPlanet() +
                ", to Planet = " + ticketByIdUpdate.getToPlanet() +
                ", Client = " + ticketByIdUpdate.getClient());


        ticketCrudService.deleteTicketById(11l);

        List<Ticket> tickets = ticketCrudService.listAllTickets();
        System.out.println("List all Tickets after delete Ticket = " + tickets);
    }
}
