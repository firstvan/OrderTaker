package hu.firstvan.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by firstvan on 2015.04.15..
 */
public class ConnectionFactory {

    static {
        try {
            // logger.info("Loading Oracle JDBC driver...");
            Class.forName("oracle.jdbc.OracleDriver");
            // logger.info("Oracle JDBC driver loaded");
        } catch(ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private static ConnectionFactory connectionFactory = new ConnectionFactory();

    static final String DB_URL = "jdbc:oracle:thin:@db.inf.unideb.hu:1521:ora11g";
    private static String DB_USER = "";
    private static String DB_PASS = "";

    public ConnectionFactory() {
        /*try {
            //DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("A meghajtó nem elérhető");
            System.exit(1);
        }*/
    }

    public Connection createConnection(){
        Connection connection = null;

        try{
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }

    public static Connection getConnection(){
        return connectionFactory.createConnection();
    }

    public static void setUser(String DB_USER) {
        ConnectionFactory.DB_USER = DB_USER;
    }

    public static void setPass(String DB_PASS) {
        ConnectionFactory.DB_PASS = DB_PASS;
    }
}
