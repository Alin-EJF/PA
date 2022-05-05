package dao;

import connections.SingletonConnection;
import tables.Continents;
import java.sql.*;

public class ContinentsDao {

        public static Continents findContinentById(int id) {
            try {
                Connection connection = SingletonConnection.getConnection();

                Statement stmt = connection.createStatement();

                ResultSet rs = stmt.executeQuery("SELECT * FROM CONTINENTS WHERE id=\'" + id + "\'");
                rs.next();

                return new Continents(rs.getInt(1),rs.getString(2));

            } catch (SQLException ex) {
                System.out.println("problema la findContinentById ");
            }

            return null;
        }

        /**
         * Method that returns an actor object identified by its name.
         */
        public static Continents findContinentByName(String name) {
            try {
                Connection connection = SingletonConnection.getConnection();

                Statement stmt = connection.createStatement();

                ResultSet rs = stmt.executeQuery("SELECT * FROM CONTINENTS WHERE name=\'" + name + "\'");
                rs.next();

                return new Continents(rs.getInt(1),rs.getString(2));
            } catch (SQLException ex) {
                System.out.println("problema la findContinentByName ");
            }

            return null;
        }

        /**
         * Method that adds a Continent's object's values to the database.
         */
        public static void createContinent(Continents continents) {
            try {
                Connection connection = SingletonConnection.getConnection();

                String sql = "INSERT INTO CONTINENTS VALUES(?, ?)";

                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery("select max(id) from CONTINENTS");
                rs.next();
                int myMaxId = rs.getInt(1);

                myMaxId++;

                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, myMaxId);
                statement.setString(2, continents.getName());
                statement.executeUpdate();



            } catch (SQLException ex) {
                System.out.println("problema la createContinent sau Continent deja existent ");
            }
        }

        public static int getNumberOfContinents() {
            try {
                Connection connection = SingletonConnection.getConnection();

                Statement stmt = connection.createStatement();

                ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM CONTINENTS");
                rs.next();

                return rs.getInt(1);
            } catch (SQLException ex) {
                System.out.println("problema la getNumberOfContinents");
            }

            return 0;
        }


}
