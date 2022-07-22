package service;

import repository.UserRepository;
import service.menu.UserMenu;

import java.sql.Connection;
import java.util.Scanner;

public class ApplicationConstant {

    public static final String[] USER_MENU = {"login,signing","exit"};
    private static UserMenu userMenu = new UserMenu();

    public static UserMenu getUserMenu() {
        return userMenu;
    }

    private static Connection connection = new DBhelper().connect();
    private static UserRepository userRepository = new UserRepository();

    public static Connection getConnection() {
        return connection;
    }

    public static UserRepository getUserRepository() {
        return userRepository;
    }

    private static Scanner input = new Scanner(System.in);

    public static Scanner getInput() {
        return input;
    }
}
