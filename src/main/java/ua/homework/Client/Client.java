package ua.homework.Client;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import ua.homework.ticket.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Table(name = "Client")
@Entity
@Data
public class Client {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column
    private String name;
    @ToString.Exclude
    @OneToMany(mappedBy = "client")
    private List<Ticket> tickets = new ArrayList<>();


}
