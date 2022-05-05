package connections;

import com.mchange.v2.c3p0.ComboPooledDataSource;


import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;


 // Class that manages a connection pool implemented using <a href="https://www.mchange.com/projects/c3p0/">C3P0</a>.
 // Calling getConnection will attempt to offer a new connection from the pool (if available).

public class ConnectionPool {
    private static ComboPooledDataSource dataSource;

    public static synchronized Connection getConnection() throws SQLException {
        if (dataSource == null) {
            try {
                dataSource = new ComboPooledDataSource();
                dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
                dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
                dataSource.setUser("javaLab");
                dataSource.setPassword("javaLab");

                dataSource.setInitialPoolSize(3);
                dataSource.setMinPoolSize(3);
                dataSource.setMaxPoolSize(21);
                dataSource.setAcquireIncrement(3);
                dataSource.setMaxIdleTime(600); // 10 minutes
            } catch (Exception ex) {
                System.err.println("Error creating the connection pool");
                ex.printStackTrace();
                System.exit(0);
            }
        }

        return dataSource.getConnection();
    }

    public static void closeConnections() {
        if (dataSource == null)
            return;

        dataSource.setMinPoolSize(0);
        dataSource.setInitialPoolSize(0);
        dataSource.setMaxIdleTime(1);
    }

}