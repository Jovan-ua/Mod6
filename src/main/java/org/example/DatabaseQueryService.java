package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private Connection connection;

    public DatabaseQueryService() {
        this.connection = Database.getInstance().getConnection();
    }

    public List<MaxProjectClient> findMaxProjectsClient() throws IOException, SQLException {
        List<MaxProjectClient> clients = new ArrayList<>();

        String query = new String(Files.readAllBytes(Paths.get("sql/find_max_projects_client.sql")));
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String name = resultSet.getString("NAME");
            int projectCount = resultSet.getInt("PROJECT_COUNT");
            clients.add(new MaxProjectClient(name, projectCount));
        }
        return clients;
    }

    public List<LongestProject> findLongestProject() {
        List<LongestProject> projects = new ArrayList<>();
        try {
            String query = new String(Files.readAllBytes(Paths.get("sql/find_longest_project.sql")));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                int monthCount = resultSet.getInt("MONTH_COUNT");
                projects.add(new LongestProject(id, monthCount));
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }

    public List<YoungestEldestWorkers> findYoungestAndEldestWorkers() throws IOException, SQLException {
        List<YoungestEldestWorkers> workers = new ArrayList<>();

            String query = new String(Files.readAllBytes(Paths.get("sql/find_youngest_eldest_workers.sql")));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String type = resultSet.getString("TYPE");
                String name = resultSet.getString("NAME");
                Date birthday = resultSet.getDate("BIRTHDAY");
                workers.add(new YoungestEldestWorkers(type, name, birthday));
            }
        return workers;
    }


    public List<MaxSalaryWorker> findWorkerWithMaxSalary() throws IOException, SQLException {
        List<MaxSalaryWorker> workers = new ArrayList<>();

        String query = new String(Files.readAllBytes(Paths.get("sql/find_max_salary_worker.sql")));
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String name = resultSet.getString("NAME");
            int salary = resultSet.getInt("SALARY");
            workers.add(new MaxSalaryWorker(name, salary));
        }
        return workers;
    }

    public List<ProjectPrice> printProjectPrices() throws IOException, SQLException {
        List<ProjectPrice> projectPrices = new ArrayList<>();
            String query = new String(Files.readAllBytes(Paths.get("sql/print_project_prices.sql")));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("NAME");
                int price = resultSet.getInt("PRICE");
                projectPrices.add(new ProjectPrice(id, price));
            }

        return projectPrices;
    }

}
