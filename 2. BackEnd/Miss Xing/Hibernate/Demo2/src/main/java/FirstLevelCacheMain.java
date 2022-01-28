import domain.Book;
import domain.Person;

import javax.persistence.*;

public class FirstLevelCacheMain {
    static EntityManagerFactory emf=Persistence.createEntityManagerFactory("domain");


    //insert may be held in cache
    private void persist() {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        //1

        Person p=new Person("Alexander","Orlov");

        System.out.println("1------------------");
        em.persist(p);
        System.out.println("2-------------------");

        em.getTransaction().commit();
        System.out.println("3--------------------");
        em.close();
    }

    private void retrive() {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        //1

        Book book=new Book("111","Hibernate");

        System.out.println("1------------------");
        em.persist(book);
        System.out.println("2-------------------");

        Book book2=em.find(Book.class,"111");
        System.out.println("3------------------"+book2.getTitle());

        em.getTransaction().commit();
        System.out.println("4--------------------");
        em.close();
    }


    private void update(){

        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        //1

        Person p=new Person("Alexander","Orlov");

        System.out.println("1------------------");
        em.persist(p);
        System.out.println("2-------------------");
        p.setFirstName("Mr x");
        System.out.println("3--------------------");
        p.setLastName("sssssssssss");
        System.out.println("4--------------------");
        em.getTransaction().commit();
        System.out.println("5--------------------");
        em.close();

    }

    private void remove(){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        //1

        Person p=new Person("Alexander","Orlov");

        System.out.println("1------------------");
        em.persist(p);
        System.out.println("2-------------------");
        p.setFirstName("ddsdscds");
        System.out.println("3---------------------");
        em.remove(p);
        System.out.println("4--------------------");
        System.out.println("5 ---------- existing "+em.contains(p));
        em.getTransaction().commit();
        System.out.println("6--------------------");
        em.close();
    }

    public void pushChanges(){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        Book book=new Book("111","Hibernate");

        System.out.println("1------------------");
        em.persist(book);
        System.out.println("2-------------------");

        book.setTitle("Spring");

        System.out.println("3---------------------");

        em.flush();
        //TypedQuery<Book> querry=em.createQuery("from Book", Book.class);
        //querry.getResultList();

        System.out.println("4----------------------");
        em.getTransaction().commit();
        System.out.println("5--------------------");
        em.close();
    }

    public static void main(String[] args) {

      FirstLevelCacheMain firstLevelCacheMain=new FirstLevelCacheMain();
      firstLevelCacheMain.pushChanges();

      emf.close();


    }
}
