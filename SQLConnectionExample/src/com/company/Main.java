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
        updateDB("Updated", "User", "updated1995","0000 Updated ST", 99, 5);

    }

    public static void writeToDB() throws SQLException, ClassNotFoundException {
        // Get instance of database connection
        dbHandler = new DBHandler();
        connection = dbHandler.getConnection();

        System.out.println("Connected to database,\n\tCATALOG:" + connection.getCatalog());

        // Create insertion string
        String insert = "INSERT INTO user(firstname,lastname,username,address,age)" +
                "VALUES(?,?,?,?,?)";

        try {

            // Create prepared statement for the connection, set values
            preparedStatement = (PreparedStatement) connection.prepareStatement(insert);
            preparedStatement.setString(1, "New");
            preparedStatement.setString(2, "User");
            preparedStatement.setString(3, "Someguy1995");
            preparedStatement.setString(4, "4321 Example st");
            preparedStatement.setInt(5, 21);

            // Execute update
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch(SQLException e){
            System.out.println("Exception encountered:\n\t" + e.getMessage());
        }
    }

    public static void readFromDB() throws SQLException {
        String query = "SELECT * FROM user";

        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            System.out.println("Names: " + resultSet.getString("firstname") + " " + resultSet.getString("lastname"));
        }
    }

    public static void updateDB(String firstName, String lastName, String userName, String address, int age, int id) throws SQLException {
        String query = "UPDATE user SET firstname = ?, lastname = ?, username = ?, address = ?, age = ? where userid = ?";


        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, userName);
            preparedStatement.setString(4, address);
            preparedStatement.setInt(5, age);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch(SQLException e){
            System.out.println("Exception encountered:\n\t" + e.getMessage());
        }
    }
}
