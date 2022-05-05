package dao;

import connections.SingletonConnection;
import tables.*;
import tables.Countries;
import java.sql.*;

public class CountriesDao{


    /**
     * Method that adds a Continent's object's values to the database.
     */
    public static void createCountry(Countries country) {
        try {
            Connection connection = SingletonConnection.getConnection();

            String sql = "INSERT INTO COUNTRIES VALUES(?, ?, ?, ?)";

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select max(id) from COUNTRIES");
            rs.next();
            int myMaxId = rs.getInt(1);

            myMaxId++;


            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, myMaxId);
            statement.setString(2, country.getName());
            statement.setString(3,country.getCode());
            statement.setString(4,country.getContinent());
            statement.executeUpdate();


        } catch (SQLException ex) {
            System.out.println("Country deja existent sau problema la createaCountry");
        }
    }


    public static Countries findCountryById(int id) {
        try {
            Connection connection = SingletonConnection.getConnection();

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM COUNTRIES WHERE id=\'" + id + "\'");
            rs.next();

            return new Countries(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));

        } catch (SQLException ex) {
            System.out.println("problema la findCountryById ");
        }

        return null;
    }


    public static Countries findCountryByName(String name) {
        try {
            Connection connection = SingletonConnection.getConnection();

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM COUNTRIES WHERE name=\'" + name + "\'");
            rs.next();

            return new Countries(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));

        } catch (SQLException ex) {
            System.out.println("problema la findCountryByName ");
        }

        return null;
    }


    public static int getNumberOfCountries() {
        try {
            Connection connection = SingletonConnection.getConnection();

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM COUNTRIES");
            rs.next();

            return rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println("problema la getNumberOfCountries");
        }

        return 0;
    }


}


