package info.fingo.data.jdbc;

import java.sql.*;
import java.util.Date;

public class JDBCTransaction {

    public static void main(String[] args) {
        String updateStatement = "UPDATE actor SET last_update=? WHERE actor_id=?";
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/dvdrental", "postgres", "postgres")) {

            try (PreparedStatement update1 = connection.prepareStatement(updateStatement);
                 PreparedStatement update2 = connection.prepareStatement(updateStatement)) {
                update1.setTimestamp(1, new Timestamp(new Date().getTime()));
                update1.setLong(2, 3L);

                update2.setTimestamp(1, new Timestamp(new Date().getTime()));
                update2.setLong(2, 4L);

                update1.executeUpdate();
                update2.executeUpdate();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


