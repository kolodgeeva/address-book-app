package dao;

import data.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    static Connection connection = null;
    static PreparedStatement ptmt = null;
    static ResultSet resultSet = null;

    public static Integer isUserValid(String login, String password) throws SQLException, ClassNotFoundException
    {
        String queryString = "SELECT * FROM usertest WHERE login=? and password=?";

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
    }

    public static String isUserRegisterValid(String login, String password, String cpassword) throws SQLException, ClassNotFoundException
    {
        String validMsg = null;

        //password length
        if(login.length() < 3){
            validMsg = "Login is short";
            return validMsg;
        }

        String queryString = "SELECT * FROM usertest WHERE login=?";

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
    }

    public static Integer registerUser(User user) throws SQLException, ClassNotFoundException
    {

        Integer id = null;

        String queryString = "insert into usertest (login, password) values(?, ?)";
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
    }

}
