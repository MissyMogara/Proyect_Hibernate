package org.hibernate_proyect.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity //Mark as entity
@Getter //Autogenerate Getters with lombok
@Setter //Autogenerate Setters with lombok
@AllArgsConstructor //Constructor with all args with lombok
@NoArgsConstructor // Constructor without args with lombok
@ToString // Method to String with lombok
public class Player {
    //PROPERTIES
    @Id //Mark as ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrement value
    private Long id;

    private String name;

    @Column(length = 50, nullable = false)
    private String nick;

    @Column(unique = true)
    private String email;

    private String language;

    @ManyToOne
    private Game favorite_game;

    private String country;


    //private String avatar; //URL IMAGE, DON'T DO IT FOR NOW
    //CONSTRUCTOR
    public Player(String name, String nick, String email, String language, String country){
        this.name = name;
        this.nick = nick;
        this.email = email;
        this.language = language;
        this.country = country;
    }
}
