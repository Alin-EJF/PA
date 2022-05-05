package dao;

import connections.SingletonConnection;
import tables.*;
import tables.Countries;
import java.sql.*;

public class CitiesDao{



    public static void createCity(Cities city) {
        try {
            Connection connection = SingletonConnection.getConnection();

            String sql = "INSERT INTO CITIES VALUES(?, ?, ?, ?, ?, ?)";

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select max(id) from CITIES");
            rs.next();
            int myMaxId = rs.getInt(1);

            myMaxId++;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, myMaxId);
            statement.setString(2, city.getCountry());
            statement.setString(3,city.getName());
            statement.setFloat(4,city.getLatitude());
            statement.setFloat(5,city.getLongitude());
            statement.setString(6,city.isCapital());
            statement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("problema la createCountry sau Country deja existent");

        }
    }

    public static Cities findCityById(int id) {
        try {
            Connection connection = SingletonConnection.getConnection();

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM CITIES WHERE id=\'" + id + "\'");
            rs.next();

            return new Cities(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getFloat(4),rs.getFloat(5),rs.getString(6));

        } catch (SQLException ex) {
            System.out.println("problema la findCityById ");
        }

        return null;
    }


    public static Cities findCityByName(String name) {
        try {
            Connection connection = SingletonConnection.getConnection();

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM CITIES WHERE name=\'" + name + "\'");
            rs.next();

            return new Cities(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getFloat(4),rs.getFloat(5),rs.getString(6));

        } catch (SQLException ex) {
            System.out.println("problema la findCityByName ");
        }

        return null;
    }


    public static int getNumberOfCities() {
        try {
            Connection connection = SingletonConnection.getConnection();

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM CITIES");
            rs.next();

            return rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println("problema la getNumberOfCities ");
        }

        return 0;
    }


}
