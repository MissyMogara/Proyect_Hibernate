package org.hibernate_proyect;

import jakarta.transaction.Transactional;
import org.hibernate_proyect.entities.Game;
import org.hibernate_proyect.entities.Player;
import org.hibernate_proyect.repositories.PlayerRepository;

public class App {
    @Transactional
    public static void main(String[] args) {

        //Create repository
        PlayerRepository playerRepository = new PlayerRepository();

        Player player1 = new Player("Miqota","Miqotilla","MiqoMiqo@gmail.com","Spanish","Spain");

        Game game1 = new Game("OW2","Steam",12);

        player1.setFavorite_game(game1);


        //Close repository
        playerRepository.closeSession();

    }
}