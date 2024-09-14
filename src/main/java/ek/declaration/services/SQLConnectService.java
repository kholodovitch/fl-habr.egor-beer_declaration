package ek.declaration.services;

import ek.declaration.Constants;
import ek.declaration.Main;
import ek.declaration.ResponseEntity;
import ek.declaration.StatusCode;

import java.sql.*;

public class SQLConnectService {

    private static Connection connection = null;

    public static void connectionClose(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Statement getConnect(String user, String password, String url, String database)  {
        Statement statement = null;

        try  {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());

            String connectionUrl =
                    "jdbc:sqlserver:" + url + ";"
                            + "database=" + database + ";"
                            + "user=" + user + ";"
                            + "password=" + password + ";"
                            + "encrypt=false;";

            connection = DriverManager.getConnection(connectionUrl);
            statement = connection.createStatement();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

}
