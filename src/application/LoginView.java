package application;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginView {
    private static final String DOCTOR_USERNAME = "doc";
    private static final String DOCTOR_PASSWORD = "docpass";
    private static final String NURSE_USERNAME = "nurse";
    private static final String NURSE_PASSWORD = "nursepass";
    private static final String PATIENT_USERNAME = "patient";
    private static final String PATIENT_PASSWORD = "patientpass";

    private Main main;

    public LoginView(Main main) {
        this.main = main;
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

            if (username.equals(DOCTOR_USERNAME) && password.equals(DOCTOR_PASSWORD)) {
                main.switchToDoctorView();
            } else if (username.equals(NURSE_USERNAME) && password.equals(NURSE_PASSWORD)) {
                main.switchToNurseView();
            } else if (username.equals(PATIENT_USERNAME) && password.equals(PATIENT_PASSWORD)) {
                main.switchToPatientPortalView();
            } else {
                messageLabel.setText("Invalid username or password");
            }
        });

        grid.add(usernameLabel, 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(loginButton, 1, 2);
        grid.add(messageLabel, 0, 3, 2, 1);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
