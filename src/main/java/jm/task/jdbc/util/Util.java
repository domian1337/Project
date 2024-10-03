package jm.task.jdbc.util;

import jm.task.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.*;
import java.util.Properties;

public class Util {

    static SessionFactory sessionFactory = null;

    static String url = "jdbc:mysql://localhost:3306/users";
    static String name = "root";
    static String password = "Ljvbfy12072003@";

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                properties.put(Environment.URL, url);
                properties.put(Environment.USER, name);
                properties.put(Environment.PASS, password);
                Configuration config = new Configuration().setProperties(properties);
                config.addAnnotatedClass(User.class);
                var builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
                sessionFactory = config.buildSessionFactory(builder.build());
            } catch (HibernateException e) {
                System.out.println("Нет соединения");
            }
        }
        return sessionFactory;
    }

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