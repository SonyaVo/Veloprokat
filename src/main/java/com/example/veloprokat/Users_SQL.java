package com.example.veloprokat;

import java.sql.*;

public class Users_SQL {
    // Статическая переменная, которая содержит единственный экземпляр класса
    private static Users_SQL instance;

    // Приватный конструктор для предотвращения создания экземпляров класса извне
    private Users_SQL() {
    }

    // Публичный статический метод для получения единственного экземпляра класса
    public static synchronized Users_SQL getInstance() {
        if (instance == null) {
            instance = new Users_SQL();
        }
        return instance;
    }

    public String isUsers(String phone, String password) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");
            String query = "SELECT phone, password FROM clients JOIN passwords USING(id_client);";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                String ph = result.getString("phone");
                String pas = result.getString("password");

                if (ph.equals(phone)) {
                    if (pas.equals(password)) {
                        return "существует";
                    } else {
                        return "пароль введен неправильно";
                    }
                }
            }

            result.close();
            statement.close();
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
        return "не существует";
    }

    public boolean addUser(String first_name, String second_name, String patronymic, String phone, String passport, String adress, String password) {
        Connection connection = null;
        boolean success = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");
            String insertClientQuery = "INSERT INTO clients (first_name, second_name, patronymic, phone, passport, adress) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertClientStatement = connection.prepareStatement(insertClientQuery);
            insertClientStatement.setString(1, first_name);
            insertClientStatement.setString(2, second_name);
            insertClientStatement.setString(3, patronymic);
            insertClientStatement.setString(4, phone);
            insertClientStatement.setString(5, passport);
            insertClientStatement.setString(6, adress);
            int clientRowsAffected = insertClientStatement.executeUpdate();

            if (clientRowsAffected > 0) {
                if (addPassword(phone, password)) {
                    success = true;
                }
            }

            insertClientStatement.close();
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
        return success;
    }

    public static int getId(String phone) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int id = -1;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");
            String query = "SELECT id_client FROM clients WHERE phone = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, phone);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id_client");
            }

            resultSet.close();
            preparedStatement.close();
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

    public static boolean addPassword(String phone, String password) {
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
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                success = true;
                System.out.println("Пароль успешно добавлен для телефона " + phone);
            } else {
                System.out.println("Не удалось добавить пароль для телефона " + phone +
                        ". Пользователь с таким телефоном не найден.");
            }

            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении SQL-запроса: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии ресурсов: " + e.getMessage());
            }
        }
        return success;
    }

    public String[] getUser(String phone) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String[] user = new String[6];

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");
            String query = "SELECT id_client, first_name, second_name, patronymic, passport, adress FROM clients WHERE phone = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, phone);
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

            resultSet.close();
            preparedStatement.close();
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
        return user;
    }

    public boolean updateSecondName(int idClient, String newSecondName) {
        return updateClientField(idClient, "second_name", newSecondName);
    }

    public boolean updateFirstName(int idClient, String newFirstName) {
        return updateClientField(idClient, "first_name", newFirstName);
    }

    public boolean updatePatronymic(int idClient, String newPatronymic) {
        return updateClientField(idClient, "patronymic", newPatronymic);
    }

    public boolean updateAdress(int idClient, String newAdress) {
        return updateClientField(idClient, "adress", newAdress);
    }

    private boolean updateClientField(int idClient, String fieldName, String newValue) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean success = false;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");
            String query = "UPDATE clients SET " + fieldName + " = ? WHERE id_client = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newValue);
            preparedStatement.setInt(2, idClient);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                success = true;
            }

            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении SQL-запроса: " + e.getMessage());
        } finally {
            try {
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