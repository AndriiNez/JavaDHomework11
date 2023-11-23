package ua.homework.client;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import ua.homework.ticket.Ticket;

import java.util.HashSet;
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
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL ,orphanRemoval = true)
    private Set<Ticket> tickets = new HashSet<>();


}
