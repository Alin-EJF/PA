package repository;


import connections.EntityManagerFactorySingleton;
import entity.ContinentsEntity;

import java.util.List;


/**
 * repository for manipulating the continent object
 */
public class ContinentRepository  extends AbstractRepository<ContinentsEntity, Integer> {
    public ContinentRepository() {
        EntityManagerFactorySingleton entityManagerFactorySingleton = EntityManagerFactorySingleton.getInstance();
        setEntityManager(entityManagerFactorySingleton.getEntityManager());
    }

    /**
     * finds the continent by its id by executing the query in the entity
     * @param id the id of the continent
     * @return the continent object
     */
    public ContinentsEntity findById(Integer id) {
        return (ContinentsEntity) getEntityManager().createNamedQuery("Continent.findById").setParameter("id", id).getSingleResult();
    }

    /**
     * find the continent by name
     * @param name the name of the continent
     * @return the list
     */
    public List<ContinentsEntity> findByName(String name) {
        return (List<ContinentsEntity>) getEntityManager().createNamedQuery("Continent.findByName").setParameter("name", name).getResultList();
    }

    /**
     * creates the continent in the database
     * @param continent the continent object
     */
    public void create(ContinentsEntity continent){
        beginTransaction();
        getEntityManager().persist(continent);
        commit();
    }
}
