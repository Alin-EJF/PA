package utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import connections.SingletonConnection;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import tables.*;
import dao.*;

public class CSVimport {





    /**
     * Method that goes through all the Countries from the CSV and calls the add function from CountriesDao to insert them.
     */
    public static void addCountriesToDb() {
        int count = 0;
        try (
                Reader reader = Files.newBufferedReader(Paths.get("concap.csv"));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {

            for (CSVRecord csvRecord : csvParser) {

                if (count != 0) {
                    String code = csvRecord.get(4);  //countryCode
                    String name = csvRecord.get(0); //countryName
                    String continent = csvRecord.get(5);  //continentName

                    var country = new Countries( name, code, continent);
                    CountriesDao.createCountry(country);



                } else count++;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void addCitiesToDb() {
        int count = 0;
        try (
                Reader reader = Files.newBufferedReader(Paths.get("concap.csv"));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {

            for (CSVRecord csvRecord : csvParser) {

                if (count != 0) {

                    String country = csvRecord.get(0);  //countryName
                    String name = csvRecord.get(1); //cityName
                    Float latitude = Float.valueOf(csvRecord.get(2));
                    Float longitude = Float.valueOf(csvRecord.get(3));
                    String capital = "Y";  //capital because all cities in csv are capitals


                    var city = new Cities(country, name, latitude, longitude, capital);
                    CitiesDao.createCity(city);



                } else count++;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
