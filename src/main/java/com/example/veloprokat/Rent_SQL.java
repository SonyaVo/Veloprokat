package com.example.veloprokat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Rent_SQL {
    public boolean addRent(int id_book, String status){
        Bookings_SQL book = new Bookings_SQL();
        Bikes_SQL bike = new Bikes_SQL();
        Tariff_SQL tariff = new Tariff_SQL();

        int id_type = bike.getTypeInBook(id_book);
        int period = book.getDaysForBook(id_book);
        int id_tariff = tariff.getId(id_type,period);

        Connection connection = null;
        boolean success = false;
        Bikes_SQL bikes = new Bikes_SQL();
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
}
