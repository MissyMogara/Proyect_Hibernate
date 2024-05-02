package org.hibernate_proyect.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@Entity //Mark as entity
@Getter //Autogenerate Getters with lombok
@Setter //Autogenerate Setters with lombok
@AllArgsConstructor //Constructor with all args with lombok
@NoArgsConstructor // Constructor without args with lombok
@ToString // Method to String with lombok
public class Match {
    @Id //Mark as ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrement value
    private Long id;

    private LocalDateTime dateHourMatch;
    private Integer matchDuration;

    @ManyToOne
    private Game game;

    @ManyToOne
    private Player winner;

    @ManyToMany
    private List<Player> playerList;

    //CONSTRUCTOR
    public Match(LocalDateTime dateHourMatch, Integer matchDuration){
        this.dateHourMatch = dateHourMatch;
        this.matchDuration = matchDuration;
    }

}
