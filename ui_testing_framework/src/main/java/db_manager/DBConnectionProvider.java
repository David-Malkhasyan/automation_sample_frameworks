package db_manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionProvider {

    protected static final Logger logger = LogManager.getLogger(DBConnectionProvider.class);
    private static final String DATABASE_NAME = "databaseName=name";
    private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String ENC_TYPE = "encrypt=true";
    private static final String SERVER_CERT = "trustServerCertificate=true";
    private static Connection connection;

    private DBConnectionProvider() {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String getURL() {
        String url = "dataabseurl";
        logger.info("Database connection String is - " + url);
        return url;
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(getURL());
                logger.info("The SQL Server connection is successfully established!");
            }
        } catch (SQLException throwables) {
            logger.error("The SQL Server connection isn't established!");
            throwables.printStackTrace();
        }
        return connection;
    }
}
