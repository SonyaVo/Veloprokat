package com.example.veloprokat;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Bookings_SQL {
    public boolean addBooking(String bike, String phone, int id_market, LocalDate date_start, LocalDate date_finish){
       // Users_SQL users = new Users_SQL();
        Connection connection = null;
        boolean success = false;
        Bikes_SQL bikes = new Bikes_SQL();
        try {
            // Проверяем наличие драйвера JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Устанавливаем соединение с базой данных
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");

            // Создаем SQL-запрос для добавления нового пользователя
            String insertBookQuery = "INSERT INTO bookings (id_client, id_bike, date_start, date_finish) VALUES (?, ?,?,?)";

            PreparedStatement insertBookStatement = connection.prepareStatement(insertBookQuery);
            insertBookStatement.setInt(1,Users_SQL.getId(phone) );
            //System.out.println(Users_SQL.getId(passport) );
            insertBookStatement.setInt(2,bikes.getId(bike, id_market,date_start) );
            insertBookStatement.setDate(3, java.sql.Date.valueOf(date_start));
            insertBookStatement.setDate(4, java.sql.Date.valueOf(date_finish));


            // Выполняем запрос на добавление клиента
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

    public int getId(String phone, LocalDate date_start){
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
            String query = "SELECT id_booking FROM bookings WHERE id_client = ? and date_start = ?;";

            preparedStatement = connection.prepareStatement(query);


            preparedStatement.setInt(1, Users_SQL.getId(phone));
            preparedStatement.setDate(2, java.sql.Date.valueOf(date_start));

            // Выполняем запрос
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                id = resultSet.getInt("id_booking");
                System.out.println(id);
            } else {
                System.out.println("не найден");

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
    public boolean getBookingForTheDate(String phone, LocalDate dateStart){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean flag = false;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");

            Statement statement = connection.createStatement();

            String query = "SELECT id_booking FROM bookings JOIN clients USING (id_client) WHERE phone = ? and date_start = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, phone);
            preparedStatement.setDate(2, java.sql.Date.valueOf(dateStart));


            // Выполняем запрос
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                flag = true;

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
        return flag;
    }

    public ArrayList<Integer> bookingsForUser(String phone){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Integer> bookings = new ArrayList<Integer>();


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");

            Statement statement = connection.createStatement();

            String query = "SELECT id_booking FROM bookings JOIN clients USING (id_client) WHERE phone = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, phone);



            // Выполняем запрос
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                bookings.add(resultSet.getInt("id_booking"));


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
        return bookings;
    }

    public boolean isInBookings(int id_booking){
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
            String query = "SELECT id_booking FROM bookings WHERE id_booking = ? ;";

            preparedStatement = connection.prepareStatement(query);


            preparedStatement.setInt(1, id_booking);


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

    public boolean deleteBooking(int id_booking) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");

            String deleteQuery = "DELETE FROM bookings WHERE id_booking = ?";

            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id_booking);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }

        }
        catch (ClassNotFoundException e) {
            System.err.println("Не найден драйвер JDBC: " + e.getMessage());
        }
        catch (SQLException e) {
            System.err.println("Ошибка при выполнении SQL-запроса: " + e.getMessage());
        }
        finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
            }
        }
        return false;
    }

    public int getDaysForBook(int id_book){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        int period = 0;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");

            Statement statement = connection.createStatement();

            String query = "SELECT SUM(DATEDIFF(date_finish, date_start)) AS period FROM bookings Where id_booking = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id_book);



            // Выполняем запрос
            result = preparedStatement.executeQuery();


            if (result.next()) {
                period = result.getInt("period");

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
        return period;
    }
}
