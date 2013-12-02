package dao;

import data.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: малыш
 * Date: 17.11.13
 * Time: 22:10
 * To change this template use File | Settings | File Templates.
 */
public class UserDao {

    static Connection connection = null;
    static PreparedStatement ptmt = null;
    static ResultSet resultSet = null;

    public static Integer isUserValid(String login, String password)
    {
        String queryString = "SELECT * FROM usertest WHERE login=? and password=?";
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, login);
            ptmt.setString(2, password);
            resultSet = ptmt.executeQuery();

            if (resultSet.next()) {

                return resultSet.getInt("id");

            } else {
                return 0;

            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return 0;
    }

    public static String isUserRegisterValid(String login, String password, String cpassword)
    {
        String validMsg = null;

        //password length
        if(login.length() < 3){
            validMsg = "Login is short";
            return validMsg;
        }


        String queryString = "SELECT * FROM usertest WHERE login=?";
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, login);
            resultSet = ptmt.executeQuery();

            if (resultSet.next()) {
                validMsg = "Such user is exists";
                return validMsg;
            }

            //password length
            if(password.length() < 5){
                validMsg = "Passwords is short";
                return validMsg;
            }

            //compare password
            if(!password.equals(cpassword)){
                validMsg = "Passwords not match";
                return validMsg;
            }

            return validMsg;


        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        validMsg = "Some error";
        return validMsg;
    }

    public static Integer registerUser(User user){

        Integer id = null;

        String queryString = "insert into usertest (login, password) values(?, ?)";
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            ptmt = connection.prepareStatement(queryString, PreparedStatement.RETURN_GENERATED_KEYS);
            ptmt.setString(1, user.getLogin());
            ptmt.setString(2, user.getPassword());

            int affectedRows = ptmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            resultSet = ptmt.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
                return  id;
            } else {
                throw new SQLException("Creating user failed, no generated key obtained.");
            }

            /*resultSet = ptmt.executeQuery();

            System.out.print(resultSet);

            if (resultSet.next()) {
                id = resultSet.getInt("id");

                System.out.print(id);

                return id;

            } else {
                return 0;

            } */
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return 0;
    }

}
