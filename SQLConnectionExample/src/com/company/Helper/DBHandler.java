package com.company.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler extends Config {
    Connection connection;

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        /*
           Set up connectionString using parameters extended from Config class
         */
        String connectionString = "jdbc:mysql://" +
                dbHost + ":" +
                dbPort + "/" +
                dbName;

         /* Get drivers needed to help with connecting localhost MySQL DB to Java
         Must surround with try/catch to avoid unhandled exception
         (Or just add throws exception to method signature)
        */
        Class.forName("com.mysql.jdbc.Driver");


        /*
           Create connection using the DriverManager.getConnection method, takes the following parameters:
           getConnection(String urlToConnectTo, String username, String password)
         */
        connection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return connection;
    }
}
