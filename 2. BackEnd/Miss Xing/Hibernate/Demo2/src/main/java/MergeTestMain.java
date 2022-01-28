import domain.Book;
import domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MergeTestMain {
    static EntityManagerFactory emf= Persistence.createEntityManagerFactory("domain");

    private void persist(){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        Person p=new Person("Alexander", "Orlov");
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }


    private void merge(){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        Person p1=em.find(Person.class,1L);
        em.detach(p1);

        Person p2=em.find(Person.class,1L);

        p1.setFirstName("Mr");

        p1=em.merge(p1);
        p1.setFirstName("Josh");

        //em.merge(p1);

        em.getTransaction().commit();
        em.close();
    }

    private void merge2(){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        Person p1=new Person("Alexander", "Orlov");
        em.merge(p1);

        Book b1=new Book("111-222-333","Hibernate ...");
        em.merge(b1);

        em.getTransaction().commit();
        em.close();
    }

    private void mergeVSpersist(){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();


        /*Book b1=new Book("111","Hibernate");
        em.persist(b1);

        Book b2=new Book("111","Spring");
        em.persist(b2);*/

        Book b1=new Book("111","Hibernate");
        em.merge(b1);

        Book b2=new Book("111","Spring");
        em.merge(b2);

        em.getTransaction().commit();
        em.close();
    }


    public static void main(String[] args) {
        MergeTestMain main=new MergeTestMain();
        main.mergeVSpersist();
        //main.persist();
        //main.merge();
    }
}
