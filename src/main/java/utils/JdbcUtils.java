package utils;

import constraint.ErrorMessage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
    private static final String URL = "jdbc:sqlite:flashcard.sqlite";

    public static Connection getConnection() {
        try{
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println(ErrorMessage.CLOSE_ERROR);
            e.printStackTrace();
        }
    }
}
