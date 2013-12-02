package dao;

import data.UserContact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: малыш
 * Date: 17.11.13
 * Time: 22:10
 * To change this template use File | Settings | File Templates.
 */
public class UserContactDao {

    static Connection connection = null;
    static PreparedStatement ptmt = null;
    static ResultSet resultSet = null;

    public ArrayList<UserContact> GetUserContacts(Integer userId)
    {
        ArrayList<UserContact> contacts = new ArrayList<UserContact>();
        // Execute SQL query
        String queryString = "SELECT * FROM user_address where user_id=?";
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, userId);
            resultSet = ptmt.executeQuery();

            while (resultSet.next()) {
                UserContact contact = new UserContact();
                contact.setId(resultSet.getInt("id"));
                contact.setName(resultSet.getString("contact_name"));
                contact.setPhone(resultSet.getString("contact_phone"));
                contacts.add(contact);
            }

            return contacts;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Boolean addContact(UserContact address)
    {
        String queryString = "insert into user_address (user_id, contact_name, contact_phone) values (?, ?, ?)";
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setInt(1, address.getUserId());
            preparedStatement.setString(2, address.getName());
            preparedStatement.setString(3, address.getPhone());
            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public UserContact getUserContactById(Integer contactId)
    {

        UserContact contact = new UserContact();
        // Execute SQL query
        String queryString = "SELECT * FROM user_address where id=?";
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, contactId);
            resultSet = ptmt.executeQuery();

            if (resultSet.next()) {
                contact.setId(resultSet.getInt("id"));
                contact.setName(resultSet.getString("contact_name"));
                contact.setPhone(resultSet.getString("contact_phone"));

                return contact;
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Boolean saveUserContact(UserContact userContact)
    {
        String queryString = "update user_address set contact_name=?, contact_phone=? where id=?";
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(queryString);

            preparedStatement.setString(1, userContact.getName());
            preparedStatement.setString(2, userContact.getPhone());
            preparedStatement.setInt(3, userContact.getId());
            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Boolean deleteUserContact(UserContact userContact)
    {
        String queryString = "delete from user_address where id=?";
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(queryString);

            preparedStatement.setInt(1, userContact.getId());
            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
