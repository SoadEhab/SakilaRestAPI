package gov.iti.jets.web.persistence.dao;

import gov.iti.jets.web.persistence.connection.DBManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class SakilaContext implements ISakila{
    EntityManager entityManager = DBManagerFactory.INSTANCE.getEntityManager();


    public <T> T add(T object){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(object);
            System.out.println("after persist\n");
            entityManager.getTransaction().commit();
            entityManager.refresh(object);
            return object;
        } catch (Exception e) {
            System.out.println(e+"ERRRRROR");
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    public <T> List<T> getAll(String namedQuery){
        TypedQuery<T> query = (TypedQuery<T>) entityManager.createNamedQuery(namedQuery);
        return query.getResultList();
    }

    public <T> T getById(Class className, int id){
        return (T)entityManager.find(className, id);
    }

    public <T,TP> List<T> getBy(String namedQuery, String paramName, TP value){
        TypedQuery<T> query = (TypedQuery<T>) entityManager.createNamedQuery(namedQuery);
        query.setParameter(paramName, value);
        return query.getResultList();
    }

    public <T> boolean update(T newObject){
        if (newObject != null) {
            entityManager.getTransaction().begin();
            entityManager.merge(newObject);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        return false;
    }

    public <T> boolean deleteById(int id, Class className) {
        T item = (T)entityManager.find(className, id);
        if (item != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(item);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }
}
