import domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Solution {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("domain");
        EntityManager em=emf.createEntityManager();

        Person p=new Person("Alexander","Orlov");
        em.getTransaction().begin();
        System.out.println("1----------------");
        em.persist(p);
        System.out.println(p);
        System.out.println("2----------------");
        p.setFirstName("Test");
        System.out.println("3----------------");
        em.getTransaction().commit();
        System.out.println("4----------------");
        em.close();
        emf.close();




    }
}
