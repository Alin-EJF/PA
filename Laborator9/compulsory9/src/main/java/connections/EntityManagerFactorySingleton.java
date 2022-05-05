package connections;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
    private static EntityManagerFactory factory;

    private EntityManagerFactorySingleton(){}

    public static EntityManager createEntityManager() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("lab9");
        }

        return factory.createEntityManager();
    }
}