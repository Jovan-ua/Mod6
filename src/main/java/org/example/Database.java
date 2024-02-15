package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:h2:~/test";
    private static final String USER = "";
    private static final String PASSWORD = "";
    private static Connection connection;
    private static Database instance;
    Database() {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Database getInstance(){
        if (instance ==null){
            instance = new Database();
        }
        return instance;
    }
    public Connection getConnection(){
        return connection;
    }
}

