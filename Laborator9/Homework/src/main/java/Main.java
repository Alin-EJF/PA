import entity.CitiesEntity;
import entity.ContinentsEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repository.CityRepository;
import repository.ContinentRepository;
import tool.ManageData;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //ManageData.importData();

//        CityRepository cityRepo = new CityRepository();

//        compulsory();

        long startTime;
        CityRepository cityRepository = new CityRepository();
        //createCity(cityRepository);
        ContinentRepository continentRepository = new ContinentRepository();
        //createContinent(continentRepository);

        startTime = System.nanoTime();
        findCityById(cityRepository);
        System.out.println("[TIME] FindCityById: " + (System.nanoTime() - startTime)*(1e-9) + " seconds");

        startTime = System.nanoTime();
        findCityByName(cityRepository);
        System.out.println("[TIME] FindCityByName: " + (System.nanoTime() - startTime)*(1e-9) + " seconds");

        startTime = System.nanoTime();
        findContinentById(continentRepository);
        System.out.println("[TIME] FindContinentById: " + (System.nanoTime() - startTime)*(1e-9) + " seconds");

        //startTime = System.nanoTime();
        //cityFindAll(cityRepository);
        //System.out.println("[TIME] CityFindAll: " + (System.nanoTime() - startTime)*(1e-9) + " seconds");



    }
    public static void compulsory() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ContinentsEntity continent = new ContinentsEntity("America");

        entityManager.getTransaction().begin();
        entityManager.persist(continent);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }

    public static void cityFindAll(CityRepository cityRepository) {
        List<CitiesEntity> cities = cityRepository.findAll();
        for (CitiesEntity city : cities) {
            System.out.println(city.getId() + city.getName());
        }
    }

    public static void createCity(CityRepository cityRepository) {
        CitiesEntity city = new CitiesEntity("Roman", "Romania", 100000);
        cityRepository.create(city);
        System.out.println("City inserted in database : " + city.getName());
    }

    public static void createContinent(ContinentRepository continentRepository) {
        ContinentsEntity continent = new ContinentsEntity("America");
        continentRepository.create(continent);
        System.out.println("Continent inserted in database : " + continent.getName());
    }

    public static void findContinentById(ContinentRepository continentRepository) {
        System.out.println(continentRepository.findById(1).getName());
    }

    public static void findCityById(CityRepository cityRepository) {
        System.out.println(cityRepository.findById(3).getId() + cityRepository.findById(3).getName());
    }

    public static void findCityByName(CityRepository cityRepository) {
        List<CitiesEntity> cities = cityRepository.findByName("Baku");

//        for (CitiesEntity city : cities) {
//            System.out.println(city.getId() + city.getName());
//        }
    }


}
