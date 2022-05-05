import connections.*;
import dao.*;
import tables.*;
import utils.CSVimport;
import utils.CityMap;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    static List<Cities> citiesList= new ArrayList<>();

    public static void main(String args[]) {

        //demoSingletonConnection();

       //demoCreateFind();
        CSVimport csv= new CSVimport();

        var Iasi=new Cities("Romania", "Iasi", 47.151726f,27.587914f,"N");
        var Bucuresti=new Cities("Romania", "Bucuresti", 44.439663f,26.096306f,"Y");

        System.out.println(Iasi.getDistanceTo(Bucuresti)+" Km");
        //CitiesDao.createCity(new Cities("Romania", "Iasi", 47.15f,27.58f,"N"));
        //CitiesDao.createCity(new Cities("Romania", "Bucuresti", 44.43f,26.09f,"Y"));

        //csv.addCountriesToDb();     IMPORT countries from csv
        //csv.addCitiesToDb();        IMPORT cities(capitals) from csv
        getCitiesFromDB();          //List of cities from db


        CityMap cityMap= new CityMap(citiesList);



    }




    public static void demoSingletonConnection() {
        try {
            Connection con = SingletonConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void demoCreateFind() {
        try {
        Connection con = SingletonConnection.getConnection();
        ContinentsDao.createContinent(new Continents("Europe"));
        ContinentsDao.createContinent(new Continents("Africa"));
        CountriesDao.createCountry(new Countries("Romania", "RO", "Europe"));
        CountriesDao.createCountry(new Countries("Italia", "IT", "Europe"));
        System.out.println(CountriesDao.findCountryById(1));
        con.close();

        } catch (SQLException e) {
        System.err.println(e);
        e.printStackTrace();
        }
        }

    public static void getCitiesFromDB(){
        try {
            Connection con = SingletonConnection.getConnection();


            for(int i=1;i<=242;i++){
                citiesList.add(CitiesDao.findCityById(i));
            }
            con.close();

        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }

    }

}