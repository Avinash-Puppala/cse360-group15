package application;

import java.util.ArrayList;

public class UserManager {
    private ArrayList<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public void createUser(String role, String username, String password) {
        User newUser = new User(role, username, password);
        users.add(newUser);
    }

    public User findUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
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
