package com.company;

import com.company.Helper.DBHandler;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    static private DBHandler dbHandler;
    static private Connection connection;

    // Allows creation of SQL queries
    static private PreparedStatement preparedStatement;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        writeToDB();
        readFromDB();

    }

    public static void writeToDB() throws SQLException, ClassNotFoundException {
        // Get instance of database connection
        dbHandler = new DBHandler();
        connection = dbHandler.getConnection();

        System.out.println("Connected to database,\n\tCATALOG:" + connection.getCatalog());

        // Create insertion string
        String insert = "INSERT INTO user(firstname,lastname,username,address,age)" +
                "VALUES(?,?,?,?,?)";

        // Create prepared statement for the connection, set values
        preparedStatement = (PreparedStatement) connection.prepareStatement(insert);
        preparedStatement.setString(1, "Test");
        preparedStatement.setString(2, "User");
        preparedStatement.setString(3, "TestUsername");
        preparedStatement.setString(4, "9999 Test st");
        preparedStatement.setInt(5, 21);

        // Execute update
        preparedStatement.executeUpdate();
    }

    public static void readFromDB() throws SQLException {
        String query = "SELECT * FROM user";

        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            System.out.println("Names: " + resultSet.getString("firstname") + " " + resultSet.getString("lastname"));
        }
    }
}
