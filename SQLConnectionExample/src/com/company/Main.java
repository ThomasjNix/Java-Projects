package com.company;

import com.company.Helper.DBHandler;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    static private DBHandler dbHandler;
    static private Connection connection;

    // Allows creation of SQL queries
    static private PreparedStatement preparedStatement;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // Get instance of database connection
        dbHandler = new DBHandler();
        connection = dbHandler.getConnection();

        System.out.println("Connected to database,\n\tCATALOG:" + connection.getCatalog());

        // Create insertion string
        String insert = "INSERT INTO user(firstname,lastname,username,address,age)" +
                "VALUES(?,?,?,?,?)";

        // Create prepared statement for the connection, set values
        preparedStatement = (PreparedStatement) connection.prepareStatement(insert);
        preparedStatement.setString(1, "Jansen");
        preparedStatement.setString(2, "Phillips");
        preparedStatement.setString(3, "JPhil323");
        preparedStatement.setString(4, "123 Make Believe St");
        preparedStatement.setInt(5, 35);

        // Execute update
        preparedStatement.executeUpdate();
    }
}
