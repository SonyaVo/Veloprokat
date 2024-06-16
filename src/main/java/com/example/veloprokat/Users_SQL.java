package com.example.veloprokat;

import java.sql.*;
import java.time.LocalDate;

public class Users_SQL {
    public String isUsers(String phone, String password) {

        Connection connection = null;
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
            String query = "SELECT phone ,password FROM clients JOIN passwords USING(id_client); ";

            // Выполняем запрос и получаем результат
            ResultSet result = statement.executeQuery(query);

            // Обрабатываем результат запроса


            outLoop:
            while (result.next()) {

                String ph = result.getString("phone");
                String pas = result.getString("password");




                if (ph.equals(phone)){
                    if (pas.equals(password)){
                        return "существует";

                    }
                    else {
                        return "пароль введен неправильно";

                    }

                }

                //System.out.print(phone);
                //System.out.print(password);

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
        return "не существует";
    }

    public boolean addUser(String first_name, String second_name, String patronymic,String phone, String passport,String adress, String password) {
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
            String insertClientQuery = "INSERT INTO clients (first_name, second_name, patronymic,phone,passport,adress) VALUES (?, ?,?,?,?,?)";

            PreparedStatement insertClientStatement = connection.prepareStatement(insertClientQuery);
            insertClientStatement.setString(1, first_name );
            insertClientStatement.setString(2, second_name);
            insertClientStatement.setString(3, patronymic);
            insertClientStatement.setString(4, phone);
            insertClientStatement.setString(5, passport);
            insertClientStatement.setString(6, adress);

            // Выполняем запрос на добавление клиента
            int clientRowsAffected = insertClientStatement.executeUpdate();


            if (clientRowsAffected > 0) {
                System.out.println("Пользователь успешно добавлен");
                if (addPassword(phone,password)){
                    success = true;
                }
            }
            else {
                System.out.println("Ошибка при добавлении пользователя");
            }

            // Закрываем ресурсы
            insertClientStatement.close();
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

    public static int getId(String phone){
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
            String query = "SELECT id_client FROM clients WHERE phone = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, phone);

            // Выполняем запрос
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                id = resultSet.getInt("id_client");
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

    public static boolean addPassword(String phone,String password){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean success = false;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");

            String query = "INSERT INTO passwords (id_client, password) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, getId(phone));
            preparedStatement.setString(2, password);

            // Выполнение запроса
            int rowsAffected = preparedStatement.executeUpdate();

            // Если добавление прошло успешно (была добавлена хотя бы одна строка), устанавливаем флаг успеха
            if (rowsAffected > 0) {
                success = true;
                System.out.println("Пароль успешно добавлен для телефона " + phone);
            } else {
                System.out.println("Не удалось добавить пароль для телефона " + phone +
                        ". Пользователь с таким телефона не найден.");
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

    public String[] getUser(String phone){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String[] user = new String[6];


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");

            Statement statement = connection.createStatement();

            String query = "SELECT id_client,first_name,second_name,patronymic,passport, adress FROM clients WHERE phone = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, phone);

            // Выполняем запрос
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                user[0] = resultSet.getString("id_client");
                user[1] = resultSet.getString("first_name");
                user[2] = resultSet.getString("second_name");
                user[3] = resultSet.getString("patronymic");
                user[4] = resultSet.getString("passport");
                user[5] = resultSet.getString("adress");

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
        return user;

    }

    public boolean updateSecondName(int idClient, String newSecondName) {
        return updateClientField(idClient, "second_name", newSecondName);
    }

    // Метод для изменения имени клиента
    public boolean updateFirstName(int idClient, String newFirstName) {
        return updateClientField(idClient, "first_name", newFirstName);
    }

    // Метод для изменения отчества клиента
    public boolean updatePatronymic(int idClient, String newPatronymic) {
        return updateClientField(idClient, "patronymic", newPatronymic);
    }

    // Метод для изменения телефона клиента
    public boolean updateAdress(int idClient, String newAdress) {
        return updateClientField(idClient, "adress", newAdress);
    }

    // Общий метод для обновления поля клиента
    private boolean updateClientField(int idClient, String fieldName, String newValue) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean success = false;

        try {
            // Установка соединения с базой данных
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");

            // SQL-запрос для обновления поля клиента
            String query = "UPDATE clients SET " + fieldName + " = ? WHERE id_client = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newValue);
            preparedStatement.setInt(2, idClient);

            // Выполнение запроса
            int rowsAffected = preparedStatement.executeUpdate();

            // Если обновление прошло успешно (была обновлена хотя бы одна строка), устанавливаем флаг успеха
            if (rowsAffected > 0) {
                success = true;
                System.out.println("Поле " + fieldName + " успешно изменено для клиента с id_client = " + idClient);
            } else {
                System.out.println("Не удалось изменить поле " + fieldName + ". Клиент с id_client = " + idClient + " не найден.");
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







}
