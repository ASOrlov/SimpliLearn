package edu.onetoone.joincolumn;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppMain {
    private static EntityManagerFactory emf= Persistence.createEntityManagerFactory("edu");

    public static void main(String[] args) {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        Customer c=new Customer("Orlov","Alex");
        Address address=new Address("1000 N 4tth", "65656");
        c.setAddress(address);
        address.setCustomer(c);

        em.persist(c);
        em.remove(c);

        em.getTransaction().commit();
        em.close();
    }
}
