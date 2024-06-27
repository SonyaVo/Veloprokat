package com.example.veloprokat;

import java.sql.*;
import java.time.LocalDate;

public class Bikes_SQL {

    // Единственный экземпляр класса
    private static Bikes_SQL instance;

    // Закрытый конструктор, чтобы предотвратить создание экземпляров извне
    private Bikes_SQL() {
        try {
            // Загружаем драйвер JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Не найден драйвер JDBC: " + e.getMessage());
        }
    }

    // Метод для получения единственного экземпляра класса
    public static synchronized Bikes_SQL getInstance() {
        if (instance == null) {
            instance = new Bikes_SQL();
        }
        return instance;
    }

    public boolean inStock(String bike, int id_markets, String date){
        int countInMarkets = inMarkets(bike,id_markets);
        int countInBook = inBook(bike,id_markets,date);
        if ((countInMarkets - countInBook <= 0)){

            return false;
        }
        else
            return true;

    }

    private int inMarkets(String bike, int id_market){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int countInMarkets = 0;
        boolean success = false;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");

            Statement statement = connection.createStatement();

            String query = "SELECT COUNT(id_bike) AS count FROM bikes WHERE id_market = ? AND name = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id_market);
            preparedStatement.setString(2, bike);

            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                countInMarkets = resultSet.getInt("count");
            }
            // Закрываем ресурсы
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении SQL-запроса: " + e.getMessage());
        } finally {
            // Закрытие ресурсов
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии ресурсов: " + e.getMessage());
            }
        }

        return countInMarkets;
    }

    private int inBook(String bike, int id_market, String date){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int countInMarkets = 0;
        boolean success = false;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");

            Statement statement = connection.createStatement();

            String query = "SELECT COUNT(id_booking) AS count FROM bookings INNER JOIN bikes USING (id_bike) " +
                    "WHERE id_market = ? AND (date_start <= ? and date_finish >= ?) and name = ?;";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id_market);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, date);
            preparedStatement.setString(4, bike);

            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                countInMarkets = resultSet.getInt("count");
            }
            // Закрываем ресурсы
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении SQL-запроса: " + e.getMessage());
        } finally {
            // Закрытие ресурсов
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии ресурсов: " + e.getMessage());
            }
        }

        return countInMarkets;

    }


    public int getId(String bike, int id_market, LocalDate date){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int id = -1;

        try {
            // Проверяем наличие драйвера JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Устанавливаем соединение с базой данных
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");

            // Создаем объект Statement для выполнения запросов к базе данных
            Statement statement = connection.createStatement();

            // Формируем SQL-запрос
            String query = "SELECT id_bike\n" +
                    "FROM bikes\n" +
                    "WHERE name = ? AND id_market = ?\n" +
                    "  AND id_bike NOT IN (\n" +
                    "    SELECT id_bike\n" +
                    "    FROM bookings\n" +
                    "    WHERE (date_start <= ? and date_finish >= ?)AND id_market = ?\n" +
                    ")" +
                    "LIMIT 1;";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, bike);
            preparedStatement.setInt(2, id_market);
            preparedStatement.setDate(3, java.sql.Date.valueOf(date));

            preparedStatement.setDate(4, java.sql.Date.valueOf(date));

            preparedStatement.setInt(5, id_market);

            // Выполняем запрос
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                id = resultSet.getInt("id_bike");
                System.out.println(id);
            }
            // Закрываем ресурсы
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Не найден драйвер JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении SQL-запроса: " + e.getMessage());
        } finally {
            try {
                // Закрываем соединение в блоке finally для обеспечения его закрытия в любом случае
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
            }
        }
        return id;
    }






}
