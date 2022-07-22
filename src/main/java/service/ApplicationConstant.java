package service;

import repository.UserRepository;

import java.sql.Connection;

public class ApplicationConstant {

    private static Connection connection = new DBhelper().connect();
    private static UserRepository userRepository = new UserRepository();

    public static Connection getConnection() {
        return connection;
    }

    public static UserRepository getUserRepository() {
        return userRepository;
    }
}
