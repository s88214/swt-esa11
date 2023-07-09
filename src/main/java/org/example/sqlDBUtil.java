package org.example;

import java.sql.*;

public class sqlDBUtil {
    private Connection connection;

    public sqlDBUtil(String url, String user, String password) {
        try {
            // get sql driver and create Connection object with passed Arguments
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        if (query == null)
            throw new IllegalArgumentException("kein Query!");
        try {
            // Erstellen Sie ein Statement-Objekt, das SQL-Abfragen senden kann
            Statement sqlStatement = connection.createStatement();
            return sqlStatement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int executeQueryReturnCount(String query) {
        if (query == null)
            throw new IllegalArgumentException("kein Query!");
        try {
            // Erstellen Sie ein Statement-Objekt, das SQL-Abfragen senden kann
            Statement sqlStatement = connection.createStatement();
            ResultSet result = sqlStatement.executeQuery(query);


            int resultSetSize = 0;
            if (result != null) {
                while (result.next()) {
                    resultSetSize++;
                }
            }
            return resultSetSize;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}