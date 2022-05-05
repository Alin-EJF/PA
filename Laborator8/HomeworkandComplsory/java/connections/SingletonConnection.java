
package connections;

import java.sql.*;

/**
 * Singleton class responsible for creating a single connection to the DB and providing it to various callers.
 */
public class SingletonConnection {
    private static Connection connection;

    private SingletonConnection() {
    }


    public static synchronized Connection getConnection() throws SQLException {
        // uses lazy initialization!
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                System.err.println("Driver not found!");
                e.printStackTrace();
                System.exit(0);
            }

            try {
                connection = DriverManager
                        .getConnection("jdbc:oracle:thin:@localhost:1521:xe", "javaLab", "javaLab");
                System.out.println("conectat cu succes la BD");
            } catch (SQLException e) {
                System.out.println("eroare la conectarea catre baza de date");
                e.printStackTrace();
            }

        }

        return connection;
    }
}