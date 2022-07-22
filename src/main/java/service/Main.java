package service;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

//        ApplicationConstant.getUserRepository().createUserTable();
//
//       User u1 = new User(-1,"hosein","sadeqi","zohress","1234");
//       ApplicationConstant.getUserRepository().createUser(u1);

        // List<User> return_user = ApplicationConstant.getUserRepository().findAllUser();
        //  System.out.println(return_user);

//        User user = ApplicationConstant.getUserRepository().findUserById(4);
//        System.out.println(user);
//        user.setfName("ali");
//        user.setlName("nouri");
//        ApplicationConstant.getUserRepository().updateUser(4,user);
        ApplicationConstant.getUserMenu().runFirstMenu();
    }


}
