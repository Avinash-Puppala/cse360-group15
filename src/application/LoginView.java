package application;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class LoginView {
    private Main main;
    private TextField usernameField;
    private PasswordField passwordField;
    private Scene scene;

    public LoginView(Main main) {
        this.main = main;
        this.usernameField = new TextField();
        this.passwordField = new PasswordField();
        usernameField.setPromptText("Username");
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> login());

        VBox layout = new VBox(usernameField, passwordField, loginButton);
        this.scene = new Scene(layout, 300, 250);
    }

    private void login() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if ("patient".equals(username) && "password".equals(password)) {
            main.switchToPatientPortalView();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText("Invalid Credentials");
            alert.setContentText("The username or password you entered is incorrect. Please try again.");
            alert.showAndWait();
        }
    }

    public Scene getScene() {
        return scene;
    }
}

