package application;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginView {
    private Main main;
    private UserManager userManager; // Instance for managing users

    public LoginView(Main main, UserManager userManager) {
        this.main = main;
        this.userManager = userManager; // Initialize user manager
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");

        GridPane grid = new GridPane();

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Label messageLabel = new Label();

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            boolean authenticated = userManager.authenticate(username, password);

            if (authenticated) {
                String role = userManager.getUserRole(username);
                switch (role) {
                    case "Doctor":
                        main.switchToDoctorView();
                        break;
                    case "Nurse":
                        main.switchToNurseView();
                        break;
                    case "Patient":
                        main.switchToPatientPortalView();
                        break;
                }
            } else {
                messageLabel.setText("Invalid username or password");
            }
        });


        Button newUserButton = new Button("Create New User");
        newUserButton.setOnAction(e -> {
            showCreateUserScreen(primaryStage);
        });

        grid.add(usernameLabel, 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(loginButton, 1, 2);
        grid.add(messageLabel, 0, 3, 2, 1);
        grid.add(newUserButton, 1, 3); // added create new user button

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showCreateUserScreen(Stage primaryStage) {
        GridPane grid = new GridPane();

        Label roleLabel = new Label("Role:");
        ComboBox<String> roleField = new ComboBox<>();
        roleField.getItems().addAll("doctor", "nurse", "patient");

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Label messageLabel = new Label();

        Button createButton = new Button("Create");
        createButton.setOnAction(e -> {
            String role = roleField.getValue();
            String username = usernameField.getText();
            String password = passwordField.getText();

            boolean success = userManager.createUser(role, username, password);

            if (success) {
                main.switchToLoginView(); // switch back to login view after creating a user
            } else {
                messageLabel.setText("Failed to create user. Username might be taken.");
            }
        });


        grid.add(roleLabel, 0, 0);
        grid.add(roleField, 1, 0);
        grid.add(usernameLabel, 0, 1);
        grid.add(usernameField, 1, 1);
        grid.add(passwordLabel, 0, 2);
        grid.add(passwordField, 1, 2);
        grid.add(createButton, 1, 3);
        grid.add(messageLabel, 0, 4, 2, 1);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
    }
}
