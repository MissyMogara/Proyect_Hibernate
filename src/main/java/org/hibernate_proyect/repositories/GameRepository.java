package org.hibernate_proyect.repositories;

import org.hibernate.Session;
import org.hibernate_proyect.HibernateUtil;
import org.hibernate_proyect.entities.Game;


import java.util.List;

public class GameRepository {
    private Session session; //Create a global session

    /**
     * Create Hibernate Session
     */
    public GameRepository(){
        session = HibernateUtil.getSessionFactory().openSession();
    }

    /**
     * Close Hibernate Session
     */
    public void closeSession() {
        session.close();
    }

    /**
     * Insert an object Game on the database.
     * @param game object (without id, if not it will update instead).
     */
    public void insert(Game game){
        session.beginTransaction();
        session.persist(game);
        session.getTransaction().commit();
    }

    /**
     * Modify a game object on the database.
     * @param game object.
     */
    public void update(Game game){
        session.beginTransaction();
        session.merge(game);
        session.getTransaction().commit();
    }

    /**
     * Returns a game object by primary key.
     * @param id primary key.
     * @return game object.
     */
    public Game findById(Long id){
        return session.find(Game.class, id);
    }

    /**
     * Deletes a game from database.
     * @param game object.
     */
    public void delete(Game game){
        session.beginTransaction();
        session.remove(game);
        session.getTransaction().commit();
    }

    /**
     * Search for all Game objects.
     * @return List of Game.
     */
    public List<Game> findAll(){
        return session.createQuery("Select g From Game g", Game.class).getResultList();
    }
}
