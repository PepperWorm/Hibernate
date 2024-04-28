package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД

    private static SessionFactory sessionFactory;

    private static final String URL = "";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    public static Connection getConnect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение с БД установлено");
            }
        } catch (SQLException e) {
            System.err.println("не удалось загрузить драйвер");
        }
        return connection;
    }

    static {
        try {
            sessionFactory = new Configuration().addAnnotatedClass(User.class).buildSessionFactory(
                    new StandardServiceRegistryBuilder().configure().build()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
