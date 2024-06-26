package com.example.veloprokat;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Tariff_SQL {

    // Единственный экземпляр класса
    private static Tariff_SQL instance;

    // Закрытый конструктор, чтобы предотвратить создание экземпляров извне
    private Tariff_SQL() {
        try {
            // Загружаем драйвер JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Не найден драйвер JDBC: " + e.getMessage());
        }
    }

    // Метод для получения единственного экземпляра класса
    public static synchronized Tariff_SQL getInstance() {
        if (instance == null) {
            instance = new Tariff_SQL();
        }
        return instance;
    }
    public int getId(int id_type, int days){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int id = -1;

        try {
            // Проверяем наличие драйвера JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");

            Statement statement = connection.createStatement();

            String query = "SELECT id_tariff FROM tariffs WHERE id_type = ? and number_of_days = ?;";

            preparedStatement = connection.prepareStatement(query);


            preparedStatement.setInt(1, id_type);
            preparedStatement.setInt(2, days);

            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                id = resultSet.getInt("id_tariff");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Не найден драйвер JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении SQL-запроса: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
            }
        }
        return id;

    }

    public int getPrice(int id_type, int days){
        int id_tariff = getId(id_type,days);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int price = 0;

        try {
            // Проверяем наличие драйвера JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");

            Statement statement = connection.createStatement();

            String query = "SELECT price FROM tariffs WHERE id_tariff = ?;";

            preparedStatement = connection.prepareStatement(query);


            preparedStatement.setInt(1, id_tariff);


            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                price = resultSet.getInt("price");

            } else {

            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Не найден драйвер JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении SQL-запроса: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
            }
        }
        return price;
    }
}
