package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) throws IOException, SQLException {
        Connection connection = Database.getInstance().getConnection();

        String queri = new String(Files.readAllBytes(Paths.get("sql/populate_db.sql")));
        String[] queris = queri.split(";");
        Statement statement = connection.createStatement();
        for (String querie : queris) {
            statement.executeUpdate(querie);
        }
        System.out.println("done");

    }


}

