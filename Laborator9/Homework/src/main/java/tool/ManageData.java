package tool;

import entity.CitiesEntity;
import repository.CityRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class ManageData {
    private static final String COMMA_DELIMITER = ",";
    private static List<List<String>> records = new ArrayList<>();


    public static void importData() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Alin\\Desktop\\lab9\\src\\main\\resources\\concap.csv"))) {
            String rand;
            while ((rand = br.readLine()) != null) {
                String[] values = rand.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        insertIntoTables();

    }

    private static void insertIntoTables() {
        CityRepository cityRepo = new CityRepository();
        Random random = new Random();
        for (List rand : records) {
            CitiesEntity city = new CitiesEntity((String) rand.get(1), (String) rand.get(0), random.nextInt(10000000) + 5000000);

            cityRepo.create(city);
        }
    }
}
