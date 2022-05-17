package info.fingo.data.jdbc;

import java.sql.*;

public class JDBCConnection {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/dvdrental", "postgres", "postgres")) {

            PreparedStatement preparedStatement = connection.prepareStatement("select * from actor where last_name like ?");
            preparedStatement.setString(1, "D%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String last_name = resultSet.getString("last_name");
                System.out.println(last_name);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
