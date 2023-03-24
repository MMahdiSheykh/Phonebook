package org.maktab.repositories;

import org.hibernate.Session;
import org.maktab.dbConnection.DbConnection;
import org.maktab.entities.Person;

import java.util.List;

public class PersonRepository {

    public void create(Person person) {
        Session session = null;
        try {
            session = DbConnection.buildSessionFactory().openSession();
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        } catch (Exception sqlException) {
            System.out.println("----------Transaction is being rolled back!----------");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Person> find() {
        Session session = null;
        List<Person> personList = null;
        try {
            session = DbConnection.buildSessionFactory().openSession();
            session.beginTransaction();
            personList = session.createQuery("FROM Person").list();
            session.getTransaction().commit();
        } catch (Exception sqlException) {
            System.out.println("----------Transaction is being rolled back----------");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return personList;
    }

    public void delete(Person person) {
        Session session = null;
        try {
            session = DbConnection.buildSessionFactory().openSession();
            session.beginTransaction();
            session.delete(person);
            session.getTransaction().commit();
        } catch (Exception sqlException) {
            System.out.println("----------Transaction is being rolled back!----------");
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
