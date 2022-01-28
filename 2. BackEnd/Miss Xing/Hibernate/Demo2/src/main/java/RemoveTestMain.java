import domain.Book;
import domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.beans.PersistenceDelegate;

public class RemoveTestMain {
 static EntityManagerFactory emf= Persistence.createEntityManagerFactory("domain");

    private void removedTransientObject(){

        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        //1. remove transient object - assigned primary key
        //Book b1=new Book("111-222-333","Hibernate");
        //em.remove(b1);

        //2. remove transient object - auto generated primary key
        //Person p1=new Person("Alexander","Orlov");
        //em.remove(p1);


        em.getTransaction().commit();
        em.close();
    }

    private void removedDetachedObject(){

        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        Person p1=new Person("Alexander","Orlov");
        em.persist(p1);
        em.getTransaction().commit();
        em.close();

        em=emf.createEntityManager();
        em.remove(p1);
        em.getTransaction().commit();
        em.close();


    }

    private void removeManagedObject(){
        persist();


        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        //Person p1=em.find(Person.class,1L);
        Person p1=em.getReference(Person.class,1L);
        em.remove(p1);

        em.getTransaction().commit();
        em.close();


    }


    private void persist(){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        Person p1=new Person("Alexander","Orlov");
        em.persist(p1);
        em.getTransaction().commit();
        em.close();
    }


    public static void main(String[] args) {

        RemoveTestMain removeTestMain=new RemoveTestMain();
        //removeTestMain.removedTransientObject();
        //removeTestMain.removedDetachedObject();
        removeTestMain.removeManagedObject();

    }
}
