package edu.secondarytable;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class AppMain {
    static EntityManagerFactory emf= Persistence.createEntityManagerFactory("edu");

    public static void main(String[] args) {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        Student s1=new Student("SNO.1", "Alex","Orlov", "Computer Science", LocalDate.of(2022,1,7));

        Student s2=new Student("SNO.2", "Alex2","Orlov2", "ARts", LocalDate.of(2021,2,7));

        em.persist(s1);
        em.persist(s2);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
