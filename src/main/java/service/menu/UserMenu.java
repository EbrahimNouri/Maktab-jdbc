package service.menu;

import entity.User;
import repository.UserRepository;
import service.ApplicationConstant;
import service.Printer;

import javax.swing.plaf.IconUIResource;
import java.sql.SQLException;

public class UserMenu {
    public void runFirstMenu() throws SQLException {
        System.out.println("welcome");
        while (true) {
            Printer.print(ApplicationConstant.USER_MENU);
            System.out.println("Enter you item ");
            int input = ApplicationConstant.getInput().nextInt();

            switch (input) {
                case 1:
                    login();
                    break;
                case 2:
                    signup();
                    break;
                case 3:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Enter correct number ");
            }
        }
    }

    public void login() throws SQLException {
        User user = new User();
        System.out.print("Enter a username : ");
        String inputUsername = ApplicationConstant.getInput().next();
        System.out.print("Enter a password : ");
        String inputPassword = ApplicationConstant.getInput().next();

        if(ApplicationConstant.getUserRepository().isUsernameExist(inputUsername)){
            //user = ApplicationConstant.getUserRepository().UserByUsername(inputUsername);
            // ok it
            if(user.getPassword().equals(inputPassword)){
                System.out.println("welcome " + user.getfName());

            }
        }else {
            System.out.println("username or password is not correct");
        }



    }

    public void signup() throws SQLException {
        User user = new User();
        String username;
        while (true) {
            System.out.println("Enter username : ");
            username = ApplicationConstant.getInput().next();
            if (ApplicationConstant.getUserRepository().isUsernameExist(username)) {
                continue;
            } else {
                user.setUserName(username);

                break;
            }
        }
        System.out.println("Enter firstname : ");
        String firstname = ApplicationConstant.getInput().next();
        user.setfName(firstname);

        System.out.println("Enter lastname : ");
        String lastname = ApplicationConstant.getInput().next();
        user.setlName(lastname);

        System.out.println("Enter password : ");
        String password = ApplicationConstant.getInput().next();
        user.setPassword(password);

        ApplicationConstant.getUserRepository().createUser(user);
    }
}
