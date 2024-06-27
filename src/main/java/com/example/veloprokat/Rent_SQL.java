package com.example.veloprokat;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Rent_SQL {

    // Единственный экземпляр класса
    private static Rent_SQL instance;

    // Закрытый конструктор, чтобы предотвратить создание экземпляров извне
    private Rent_SQL() {
        try {
            // Загружаем драйвер JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Не найден драйвер JDBC: " + e.getMessage());
        }
    }

    // Метод для получения единственного экземпляра класса
    public static synchronized Rent_SQL getInstance() {
        if (instance == null) {
            instance = new Rent_SQL();
        }
        return instance;
    }
    public boolean addRent(int id_book, String status){
        Bookings_SQL book = Bookings_SQL.getInstance();
        Tariff_SQL tariff = Tariff_SQL.getInstance();
        int id_type = book.getTypeInBook(id_book);
        int period = book.getDaysForBook(id_book);
        int id_tariff = tariff.getId(id_type,period);

        Connection connection = null;
        boolean success = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");

            String insertBookQuery = "INSERT INTO rents (id_booking, id_tariff, status) VALUES (?, ?,?)";

            PreparedStatement insertBookStatement = connection.prepareStatement(insertBookQuery);
            insertBookStatement.setInt(1,id_book );
            insertBookStatement.setInt(2,id_tariff );
            insertBookStatement.setString(3,status );


            int bookRowsAffected = insertBookStatement.executeUpdate();


            if (bookRowsAffected > 0) {
                success = true;
            }
            else {
                System.out.println("Ошибка при добавлении пользователя");
            }

            // Закрываем ресурсы
            insertBookStatement.close();
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
        return success;
    }

    public boolean isInRent(int id_book) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


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
            String query = "SELECT id_booking FROM rents WHERE id_booking = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id_book);

            // Выполняем запрос
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
               return true;
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
        return false;
    }

    public boolean setStaus(int id_book, String status){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean success = false;

        try {
            // Установка соединения с базой данных
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");

            // SQL-запрос для обновления поля клиента
            String query = "UPDATE rents SET status = ? WHERE id_booking = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, id_book);

            // Выполнение запроса
            int rowsAffected = preparedStatement.executeUpdate();

            // Если обновление прошло успешно (была обновлена хотя бы одна строка), устанавливаем флаг успеха
            if (rowsAffected > 0) {
                success = true;
            }

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

        return success;
    }

    public String getStatus(int id_book){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        String status = "";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");

            Statement statement = connection.createStatement();

            String query = "SELECT status FROM rents Where id_booking = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id_book);



            // Выполняем запрос
            result = preparedStatement.executeQuery();


            if (result.next()) {
                status = result.getString("status");

            }
            // Закрываем ресурсы
            result.close();
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
        return status;
    }

    public ArrayList<Integer> getRentsFor(String phone){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        String status = "";
        ArrayList<Integer> list = new ArrayList<>();


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");

            Statement statement = connection.createStatement();

            String query = "SELECT id_booking FROM rents Join bookings USING(id_booking) Where id_client = ?";

            //Users_SQL usersSql = new Users_SQL();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,Users_SQL.getId(phone));



            // Выполняем запрос
            result = preparedStatement.executeQuery();


            while (result.next()) {
                list.add(result.getInt("id_booking"));
            }
            // Закрываем ресурсы
            result.close();
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
        return list;
    }
}
