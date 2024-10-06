package jm.task.jdbc.util;

import java.sql.DriverManager;
import java.sql.*;

public class Util {

    public static String url = "jdbc:mysql://localhost:3306/users";
    public static String name = "root";
    public static String password = "root";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, name, password);
        } catch (SQLException e) {
            System.out.println("Таблица не создана!");
        }
        return connection;
    }
}
