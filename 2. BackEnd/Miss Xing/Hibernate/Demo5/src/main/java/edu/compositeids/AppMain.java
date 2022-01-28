package edu.compositeids;


import edu.secondarytable.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class AppMain {
    static EntityManagerFactory emf= Persistence.createEntityManagerFactory("edu");

    public static void main(String[] args) {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        Name name=new Name("Alex","Orlov");
        Person person=new Person(name,LocalDate.of(2019,11,3));

        Address address=new Address("1000 N 4th","454543");
        person.addAddress(address);
        Address address1=new Address("1001 N 4th","154543");
        person.addAddress(address1);

        em.persist(person);

        /*Name name2=new Name("Alex2","Orlov");
        Person person2=new Person(name2,LocalDate.now());
        em.persist(person2);*/

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
