package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManager {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/UserDatabase";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "Nagesh2846274720*";

    public boolean createUser(String role, String username, String password) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Users (role, username, password) VALUES (?, ?, ?)");
            statement.setString(1, role);
            statement.setString(2, username);
            statement.setString(3, password);
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            // Handle any errors
            e.printStackTrace();
            return false;
        }
    }

    public User findUser(String username) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE username = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String role = resultSet.getString("role");
                String password = resultSet.getString("password");
                return new User(role, username, password);
            }
        } catch (SQLException e) {
            // Handle any errors
            e.printStackTrace();
        }
        return null; // User not found
    }

    public boolean authenticate(String username, String password) {
        User user = findUser(username);
        return user != null && user.getPassword().equals(password);
    }

    public String getUserRole(String username) {
        User user = findUser(username);
        if (user != null) {
            return user.getRole();
        }
        return null;
    }
}
