package com.panarik.manager.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseController {

    private static DatabaseController instance; // Current instance.
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    private DatabaseController() {
    }

    public static synchronized DatabaseController getInstance() {
        if (instance == null) instance = new DatabaseController();
        return instance;
    }

    /**
     * Get {@link Tool} list from database.
     */
    public List<Tool> getTools() {
        List<Tool> tools = new ArrayList<>(); // List with all tools fields.
        List<String> toolNames = new ArrayList<>(); // List with tools names.

        connect();

        try (ResultSet resultSet = execute("SELECT ToolName FROM Tools")) { // Get tool names.
            while (resultSet.next()) toolNames.add(resultSet.getString(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(toolNames);


        for (String toolName : toolNames) { // Get tools checkers.
            List<String> checkers = new ArrayList<>();
            try (ResultSet resultSet = execute("SELECT * FROM Verifying WHERE ToolName='" + toolName + "'")) {
                while (resultSet.next()) checkers.add(resultSet.getString(2));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            tools.add(new Tool(toolName, checkers));
        }

        disconnect();
        return tools;
    }

    private ResultSet execute(String request) throws SQLException {
        resultSet = statement.executeQuery(request);
        return resultSet;
    }

    private void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:tools.db");
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.err.println("Check your jdbc driver dependency and database path.");
            throw new RuntimeException(e);
        }
    }

    private void disconnect() {
        try {
            if (connection != null) connection.close();
            if (statement != null) statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
