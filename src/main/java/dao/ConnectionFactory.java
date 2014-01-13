package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    String driverClassName = "com.mysql.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost:3306/somedb";
    String dbUser = "root";
    String dbPwd = "";

    private static ConnectionFactory connectionFactory = null;

    private ConnectionFactory() throws ClassNotFoundException{
        Class.forName(driverClassName);
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        return conn;
    }

    public static ConnectionFactory getInstance() throws ClassNotFoundException{
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }
}
