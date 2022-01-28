package edu.queries;


import javax.persistence.*;
import java.util.List;

public class App {
    private static EntityManagerFactory emf= Persistence.createEntityManagerFactory("edu");



    private static void createQuery(){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        //Query query = em.createQuery("from Person");
        TypedQuery<Person> querry=em.createQuery("from Person", Person.class);
        List<Person> personList=querry.getResultList();

        System.out.println(personList);

        em.getTransaction().commit();
        em.close();
    }

    private static void namedQuerry(){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery query=em.createNamedQuery("Person.everyone",Person.class);
        List<Person> personList=query.getResultList();


        System.out.println(personList);

        em.getTransaction().commit();
        em.close();
    }


    private static void polymorphicQuerry(){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        Account checking=new CheckingAccount(100.00,20.00);
        em.persist(checking);
        Account savings=new SavingAccount(100.00,200.00);
        em.persist(savings);

        TypedQuery<Account> query=em.createQuery("from Account", Account.class);
        List<Account> accounts=query.getResultList();

        System.out.println(accounts);

        em.getTransaction().commit();
        em.close();
    }

    private static void aliasesQuerry(){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Person> query = em.createQuery("from Person as p where p.id=1",Person.class);
        System.out.println(query.getResultList());

        em.getTransaction().commit();
        em.close();
    }


    private static void pagination(){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Person> query = em.createQuery("from Person",Person.class);
        query.setFirstResult(7);
        query.setMaxResults(5);

        List<Person> people=query.getResultList();

        System.out.println(people.size());
        System.out.println(people);

        em.getTransaction().commit();
        em.close();
    }

    //Order by last name
    private static void orderBy(){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Person> query = em.createQuery("from Person p order by p.lastName desc ",Person.class);
        List<Person> personList=query.getResultList();

        System.out.println(personList);

        em.getTransaction().commit();
        em.close();
    }

    private static void whereClause(){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Person> query = em.createQuery("from Person p where p.lastName like '%n%'",Person.class);
        List<Person> personList=query.getResultList();

        System.out.println(personList);

        em.getTransaction().commit();
        em.close();
    }

    private static void queryParameters(){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        String firstName="John";
        //NOT GOOD
        //TypedQuery<Person> query = em.createQuery("from Person p where p.firstName ='"+firstName+"'",Person.class);

        //1. Named parameters
        //TypedQuery<Person> query = em.createQuery("from Person p where p.firstName =:firstName",Person.class);
        //query.setParameter("firstName",firstName);

        //2. Using position
        TypedQuery<Person> query = em.createQuery("from Person p where p.firstName = ?1",Person.class);
        query.setParameter(1,firstName);

        List<Person> personList=query.getResultList();
        System.out.println(personList);

        em.getTransaction().commit();
        em.close();
    }

    private static void singleResult(){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Person> query = em.createQuery("from Person p where p.id=123",Person.class);
        //Person person=query.getSingleResult();
        //System.out.println(person);

        query.setMaxResults(1);
        List<Person> p=query.getResultList();
        System.out.println(p.size());
        // System.out.println(p.get(0));


        em.getTransaction().commit();
        em.close();
    }

    private static void specialAttributeId(){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Person> query = em.createQuery("from Person p where id=1",Person.class);
        List<Person> p=query.getResultList();
        System.out.println(p);

        em.getTransaction().commit();
        em.close();
    }

    private static void joinCollection(){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        Person p1=new Person("John","Brown");
        p1.addPhoneNumber(new PhoneNumber("641-472-1234","Home"));
        p1.addPhoneNumber(new PhoneNumber("641-919-5432","Mobile"));
        em.persist(p1);

        Person p2=new Person("Edward","Towers");
        p2.addPhoneNumber(new PhoneNumber("641-233-9876","Mobile"));
        p2.addPhoneNumber(new PhoneNumber("641-888-0987","Home"));
        em.persist(p2);


       /* TypedQuery<Object[]> query=em.createQuery("from Person p join p.numbers n where n.number like '641%'",Object[].class);
        List<Object[]> list = query.getResultList();

        for (Object[] obj : list) {
            System.out.println((Person)obj[0]);
            System.out.println((PhoneNumber)obj[1]);
        }*/

        //2. use select clause
        /*TypedQuery<Person> query2=em.createQuery("select p from Person p join p.numbers n where n.number like '641%'",Person.class);
        List<Person> personList=query2.getResultList();
        System.out.println(personList);*/

        //3. use distinct
        TypedQuery<Person> query2=em.createQuery("select distinct p from Person p join p.numbers n where n.number like '641%'",Person.class);
        List<Person> personList=query2.getResultList();
        System.out.println(personList);

        em.getTransaction().commit();
        em.close();
    }

    private static void joinFetch(){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        Person p1=new Person("John","Brown");
        p1.addPhoneNumber(new PhoneNumber("641-472-1234","Home"));
        p1.addPhoneNumber(new PhoneNumber("641-919-5432","Mobile"));
        em.persist(p1);

        Person p2=new Person("Edward","Towers");
        p2.addPhoneNumber(new PhoneNumber("641-233-9876","Mobile"));
        p2.addPhoneNumber(new PhoneNumber("641-888-0987","Home"));
        em.persist(p2);

        em.getTransaction().commit();
        em.close();

        em=emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("1......................");

        TypedQuery<Person> query2=em.createQuery("from Person p join fetch p.numbers n where n.number like '641%'",Person.class);
        List<Person> personList=query2.getResultList();

        personList.stream().forEach(p-> {
            System.out.println("2......................");
            System.out.println(p.getNumbers());
            System.out.println("3......................");
        });



        em.getTransaction().commit();
        em.close();

    }

    public static void main(String[] args) {
        //createQuery();
        //namedQuerry();
        //polymorphicQuerry();
        //aliasesQuerry();
        //pagination();
        //orderBy();
        //whereClause();
        //queryParameters();
        //singleResult();
        //specialAttributeId();
        //joinCollection();
        joinFetch();

        emf.close();
    }



}
