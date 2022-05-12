package repository;


import connections.EntityManagerFactorySingleton;
import entity.CountriesEntity;

import java.util.List;

public class CountryRepository  extends AbstractRepository<CountriesEntity, Integer> {
    /**
     * constructor for the country repository that
     * initializes the EntityManagerFactorySingleton
     */
    public void CountryRepository() {
        EntityManagerFactorySingleton entityManagerFactorySingleton = EntityManagerFactorySingleton.getInstance();
        setEntityManager(entityManagerFactorySingleton.getEntityManager());
    }

    /**
     * finds the country by its id by executing the query in the entity
     * @param id the id of the country
     * @return the country object
     */
    public CountriesEntity findById(Integer id) {
        return (CountriesEntity) getEntityManager().createNamedQuery("Country.findById").setParameter("id", id).getSingleResult();
    }

    public List<CountriesEntity> findByName(String name) {
        return (List<CountriesEntity>) getEntityManager().createNamedQuery("Country.findByName").setParameter("name", name).getResultList();
    }

    /**
     * creates the country in the database
     * @param country the country object
     */
    public void create(CountriesEntity country){
        beginTransaction();
        getEntityManager().persist(country);
        commit();
    }
}

