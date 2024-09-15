package ek.declaration.services;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnectService {

    private static Connection connection = null;

    public static void connectionClose() {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Statement getConnect(String user, String password, String url, String database) {
        Statement statement = null;

        try {
            DriverManager.registerDriver(new SQLServerDriver());
            String connectionUrl = String.format("jdbc:sqlserver:%s;database=%s;user=%s;password=%s;encrypt=false;",
                    url, database, user, password);

            connection = DriverManager.getConnection(connectionUrl);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

}
