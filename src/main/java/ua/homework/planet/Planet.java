package ua.homework.planet;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import ua.homework.ticket.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Table(name = "Planet")
@Entity
@Data
public class Planet {

    @Id
    private String id;

    @Column
    private String name;
    @ToString.Exclude
    @OneToMany(mappedBy = "fromPlanet")
    private List<Ticket> ticketsFrom = new ArrayList<>();
    @ToString.Exclude
    @OneToMany(mappedBy = "toPlanet")
    private List<Ticket> ticketsTo = new ArrayList<>();

}
