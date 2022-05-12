package repository;

import connections.EntityManagerFactorySingleton;
import entity.CitiesEntity;

import java.util.List;

public class CityRepository extends AbstractRepository<CitiesEntity, Integer> {

    /**
     * constructor for the CitiesEntity repository that
     * initializes the EntityManagerFactorySingleton
     */
    public CityRepository() {
        EntityManagerFactorySingleton entityManagerFactorySingleton = EntityManagerFactorySingleton.getInstance();
        setEntityManager(entityManagerFactorySingleton.getEntityManager());
    }

    /**
     * finds the CitiesEntity by its id by executing the query in the entity
     * @param id the id of the CitiesEntity
     * @return the CitiesEntity object
     */
    public CitiesEntity findById(Integer id) {
        return (CitiesEntity) getEntityManager().createNamedQuery("City.findById").setParameter("id", id).getSingleResult();
    }

    /**
     * find all the cities by executing the query
     * @return the list with all the present cities
     */
    public List<CitiesEntity> findAll() {
        return (List<CitiesEntity>) getEntityManager().createNamedQuery("City.findAll").getResultList();
    }

    /**
     * find the CitiesEntity by name
     * @param name the name of the CitiesEntity
     * @return the list
     */
    public List<CitiesEntity> findByName(String name) {
        return (List<CitiesEntity>) getEntityManager().createNamedQuery("City.findByName").setParameter("name", name).getResultList();
    }

    /**
     * creates the CitiesEntity in the database
     * @param city
     */
    public void create(CitiesEntity city){
        beginTransaction();
        getEntityManager().persist(city);
        commit();
    }
}