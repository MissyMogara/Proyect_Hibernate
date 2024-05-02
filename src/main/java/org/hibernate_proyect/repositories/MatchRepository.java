package org.hibernate_proyect.repositories;

import org.hibernate.Session;
import org.hibernate_proyect.HibernateUtil;
import org.hibernate_proyect.entities.Match;


import java.util.List;

public class MatchRepository {
    private Session session; //Create a global session

    /**
     * Create Hibernate Session
     */
    public MatchRepository(){
        session = HibernateUtil.getSessionFactory().openSession();
    }

    /**
     * Close Hibernate Session
     */
    public void closeSession() {
        session.close();
    }

    /**
     * Insert an object Match on the database.
     * @param match object (without id, if not it will update instead).
     */
    public void insert(Match match){
        session.beginTransaction();
        session.persist(match);
        session.getTransaction().commit();
    }

    /**
     * Modify a match object on the database.
     * @param match object.
     */
    public void update(Match match){
        session.beginTransaction();
        session.merge(match);
        session.getTransaction().commit();
    }

    /**
     * Returns a Match object by primary key.
     * @param id primary key.
     * @return match object.
     */
    public Match findById(Long id){
        return session.find(Match.class, id);
    }

    /**
     * Deletes a Match from database.
     * @param match object.
     */
    public void delete(Match match){
        session.beginTransaction();
        session.remove(match);
        session.getTransaction().commit();
    }

    /**
     * Search for all Match objects.
     * @return List of Match.
     */
    public List<Match> findAll(){
        return session.createQuery("Select m From Match m", Match.class).getResultList();
    }
}
