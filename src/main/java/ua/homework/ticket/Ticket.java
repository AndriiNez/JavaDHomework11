package ua.homework.ticket;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import ua.homework.Client.Client;
import ua.homework.planet.Planet;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false)
    private String createdAt;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "from_planet_id", nullable = false)
    private Planet fromPlanet;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "to_planet_id", nullable = false)
    private Planet toPlanet;

}
