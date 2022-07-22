package service.menu;

import service.ApplicationConstant;
import service.Printer;

public class UserMenu {
    public void runFirstMenu() {
        System.out.println("welcome");
        while (true) {
            Printer.print(ApplicationConstant.USER_MENU);
            System.out.println("Enter you item ");
            int input = ApplicationConstant.getInput().nextInt();

            switch (input) {
                case 1:
                    login();
                    break;
                case 2 :
                    signin();
                    break;
                case 3:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Enter correct number ");
            }
        }
    }

    public void login() {

    }

    public void signin() {

    }


}
