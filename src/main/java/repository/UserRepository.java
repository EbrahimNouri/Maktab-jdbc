package repository;

import entity.User;
import service.ApplicationConstant;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public User findUserById(long id) throws SQLException {
        User foundUser = new User();
        PreparedStatement stm = ApplicationConstant.getConnection().prepareStatement("select * from user_table where id = ?");
        stm.setLong(1, id);

        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            foundUser.setId(rs.getLong(1));
            foundUser.setfName(rs.getString(2));
            foundUser.setlName(rs.getString(3));
            foundUser.setUserName(rs.getString(4));
            foundUser.setPassword(rs.getString(5));
        }
        return foundUser;

    }

    public User createUser(User user) throws SQLException {
        if (isUsernameExist(user.getUserName())) {
            System.out.println("username already exists");
            return null;
        } else {
            String sql = "insert  into user_table (firstname,lastname,username,password) values (?,?,?,?)";
            PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getfName());
            ps.setString(2, user.getlName());
            ps.setString(3, user.getUserName());
            ps.setString(4, user.getPassword());

            ps.executeUpdate();
            if (ps.getGeneratedKeys().next()) {
                user.setId(ps.getGeneratedKeys().getLong(1));
            }
            System.out.println("user created successfully");
            return user;
        }
    }
    public void deleteUser(long id) throws SQLException {
        String sql = "DELETE FROM user_table id = ?";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setLong(1,id);
        int check = ps.executeUpdate();
        if (check == 1){

            System.out.println("user delete successfully");
        }


    }

    public void updateUser(long id , User user) throws SQLException {
        String sql = "update user_table firstname = ? , lastname = ?, username = ? , pssword = ?  where id = ?";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setString(1,user.getfName());
        ps.setString(2,user.getlName());
        ps.setString(3, user.getUserName());
        ps.setString(4, user.getPassword());
        ps.setLong(5,id);
        int check = ps.executeUpdate();
        if(check == 1){
            System.out.println("DONE");
        }

    }

    public List<User> findAllUser() throws SQLException {

        List<User> allUser = new ArrayList<>();
        String sql = "select * from user_table";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
       if(rs.next()) {
           while (rs.next()) {
               allUser.add(new User(rs.getLong(1),
                       rs.getString(2),
                       rs.getString(3),
                       rs.getString(4),
                       rs.getString(5)));
           }
       }else{
           System.out.println("user not exists !!!!");
       }
        return allUser;
    }

    public boolean isUsernameExist(String username) throws SQLException {

        PreparedStatement stm = ApplicationConstant.getConnection().prepareStatement("select * from user_table where username = ?");
        stm.setString(1,username);
        ResultSet rs = stm.executeQuery();
        if(rs.next()){
            System.out.println(username+" already exists");
            return true;
        }else{
            System.out.println("username is correct");
            return false;
        }

    }


    public void createUserTable() throws SQLException {
        Statement stm = ApplicationConstant.getConnection().createStatement();
        stm.executeUpdate("create table if not exists user_table(" +
                "id serial primary key not null ," +
                "firstName varchar(30) ," +
                "lastName varchar(30)," +
                "username varchar (30) unique not null," +
                "password varchar (80)not null )");


    }
}
