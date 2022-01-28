package edu.singletable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppMain {
    static EntityManagerFactory ef= Persistence.createEntityManagerFactory("edu");

    public static void main(String[] args) {
        EntityManager em= ef.createEntityManager();
        em.getTransaction().begin();


        Account checking=new Checking(100.0,20.0);
        em.persist(checking);

        Savings savings=new Savings(2000.0,200.0);
        em.persist(savings);

        em.getTransaction().commit();

        em.close();
        ef.close();
    }
}
