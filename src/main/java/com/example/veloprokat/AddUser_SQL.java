package com.example.veloprokat;

import java.sql.*;

public class AddUser_SQL {
    public boolean addUsers(String first_name, String second_name, String patronymic,String phone, String passport,String adress, String password) {
        Connection connection = null;
        boolean success = false;
        try {
            // Проверяем наличие драйвера JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Устанавливаем соединение с базой данных
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");

            // Создаем SQL-запрос для добавления нового пользователя
            String insertClientQuery = "INSERT INTO users (first_name, second_name, patronymic,phone,passport,adress) VALUES (?, ?,?,?,?,?)";

            PreparedStatement insertClientStatement = connection.prepareStatement(insertClientQuery);
            insertClientStatement.setString(1, first_name );
            insertClientStatement.setString(2, second_name);
            insertClientStatement.setString(3, patronymic);
            insertClientStatement.setString(4, phone);
            insertClientStatement.setString(5, passport);
            insertClientStatement.setString(6, adress);

            // Выполняем запрос на добавление клиента
            int clientRowsAffected = insertClientStatement.executeUpdate();

            // Создаем SQL-запрос для добавления нового пароля
            String insertPasswordQuery = "INSERT INTO passwords (password) VALUES (?)";
            PreparedStatement insertPasswordStatement = connection.prepareStatement(insertPasswordQuery);
            insertPasswordStatement.setString(1, password);

            // Выполняем запрос на добавление пароля
            int passwordRowsAffected = insertPasswordStatement.executeUpdate();

            if (clientRowsAffected > 0 && passwordRowsAffected > 0) {
                System.out.println("Пользователь успешно добавлен");
                success = true;
            } else {
                System.out.println("Ошибка при добавлении пользователя");
            }

            // Закрываем ресурсы
            insertClientStatement.close();
            insertPasswordStatement.close();
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
}
