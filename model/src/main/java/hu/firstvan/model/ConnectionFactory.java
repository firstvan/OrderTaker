package hu.firstvan.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Create connection to database.
 */
public class ConnectionFactory implements AutoCloseable {

    /**
     * This is a static variable to logging.
     */
    private static Logger logger = LoggerFactory.getLogger(ConnectionFactory.class);

    /**
     * Register database driver.
     */
    static {
        try {
            logger.info("Loading Oracle JDBC driver...");
            Class.forName("oracle.jdbc.OracleDriver");
            logger.info("Oracle JDBC driver loaded");
        } catch (ClassNotFoundException e) {
            logger.error("Oracle JDBC driver could not be loaded.");
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Via this can be acess the database.
     */
    private static ConnectionFactory connectionFactory = new ConnectionFactory();

    /**
     * Database access url.
     */
    static final String DB_URL = "jdbc:oracle:thin:@db.inf.unideb.hu:1521:ora11g";

    /**
     * Database user name.
     */
    private static String DB_USER = "";

    /**
     * Database password.
     */
    private static String DB_PASS = "";

    /**
     * Connection of database.
     */
    private static Connection connection = null;

    /**
     * Information from connection was successful.
     */
    private static boolean success = false;

    /**
     * Default constructor.
     */
    public ConnectionFactory() {
        logger.info("ConnectionFactory is created");
    }

    /**
     * Create connection to database.
     */
    private static void createConnection() {
        try {
            if (DB_USER == null || DB_PASS == null) {
                success = false;
                logger.error("User and password is empty.");
            } else {
                logger.info("Connecting to database...");
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                logger.info("Connected to database.");
                success = true;
            }
        } catch (SQLException e) {
            success = false;
            logger.error("Unable to connect to database.");
        }

    }

    /**
     * Get connection from driver manager and return it.
     *
     * @return Connection of database
     */
    public static Connection getConnection() {
        createConnection();
        return connection;
    }

    /**
     * Set database user name.
     *
     * @param DB_USER user name of database
     */
    public static void setUser(String DB_USER) {
        ConnectionFactory.DB_USER = DB_USER;
        logger.info("Database user name set.");
    }

    /**
     * Set database password.
     *
     * @param DB_PASS password name of database
     */
    public static void setPass(String DB_PASS) {
        ConnectionFactory.DB_PASS = DB_PASS;
        logger.info("Database password set.");
    }

    /**
     * Return username of database.
     *
     * @return username of database
     */
    public static String getUser() {
        return DB_USER;
    }

    /**
     * Return password of database.
     *
     * @return password of database
     */
    public static String getPass() {
        return DB_PASS;
    }

    /**
     * Method to implement auto closeable interface. Close database connection.
     *
     * @throws Exception cannot close the connection
     */
    @Override
    public void close() throws Exception {
        connection.close();
    }

    /**
     * Test the connection to database.
     *
     * @return result of test the connection to database
     */
    public static boolean test() {
        createConnection();
        if (success) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return success;
    }
}
