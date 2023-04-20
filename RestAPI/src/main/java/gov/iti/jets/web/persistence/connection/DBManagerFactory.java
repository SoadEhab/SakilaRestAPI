package gov.iti.jets.web.persistence.connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public enum DBManagerFactory {
    INSTANCE;
    EntityManagerFactory entityManagerFactory;
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
    DBManagerFactory(){
        entityManagerFactory = Persistence.createEntityManagerFactory("sakilaAPI");
    }
}