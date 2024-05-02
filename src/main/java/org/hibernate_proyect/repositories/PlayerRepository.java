package org.hibernate_proyect.repositories;


import org.hibernate_proyect.HibernateUtil;
import org.hibernate.Session;
import org.hibernate_proyect.entities.Player;

import java.util.List;

public class PlayerRepository {
    private Session session; //Create a global session

    /**
     * Create Hibernate Session
     */
    public PlayerRepository(){
        session = HibernateUtil.getSessionFactory().openSession();
    }

    /**
     * Close Hibernate Session
     */
    public void closeSession() {
        session.close();
    }

    /**
     * Insert an object Player on the database.
     * @param player object (without id, if not it will update instead).
     */
    public void insert(Player player){
        session.beginTransaction();
        session.persist(player);
        session.getTransaction().commit();
    }

    /**
     * Modify a player object on the database.
     * @param player object.
     */
    public void update(Player player){
        session.beginTransaction();
        session.merge(player);
        session.getTransaction().commit();
    }

    /**
     * Returns a player object by primary key.
     * @param id primary key.
     * @return player object.
     */
    public Player findById(Long id){
        return session.find(Player.class, id);
    }

    /**
     * Deletes a player from database.
     * @param player object.
     */
    public void delete(Player player){
        session.beginTransaction();
        session.remove(player);
        session.getTransaction().commit();
    }

    /**
     * Search for all Player objects.
     * @return List of Player.
     */
    public List<Player> findAll(){
        return session.createQuery("Select p From Player p", Player.class).getResultList();
    }

}
