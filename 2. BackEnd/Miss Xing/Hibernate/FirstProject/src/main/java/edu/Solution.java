package edu;

import edu.alex.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {

        EntityManagerFactory factory= Persistence.createEntityManagerFactory("edu.alex");
        EntityManager em=factory.createEntityManager();

        EntityTransaction et=em.getTransaction();
        et.begin();
        User user=new User("Alexander", "Orlov","it9@inbox.ru", new Date(), LocalDate.of(2019,12,21));
        em.persist(user);
        et.commit();
        //em.createQuery("from User");
        //em.createNativeQuery("select * from people");
        em.close();




    }
}
