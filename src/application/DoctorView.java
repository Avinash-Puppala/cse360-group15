package application;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class DoctorView {
    private Main main;
    private BorderPane rootLayout;
    private TextField idField;
    private static final String PATIENT_ID = "12345";
    private Label messageLabel;

    public DoctorView(Main main) {
        this.main = main;
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Doctor View");

        rootLayout = new BorderPane();

        VBox menu = new VBox();
        menu.setSpacing(10);

        Button examineButton = new Button("Examine Patient");
        examineButton.setOnAction(e -> showExamine());

        Button prescribeButton = new Button("Prescribe Medication");
        prescribeButton.setOnAction(e -> showPrescribe());

        Button historyButton = new Button("View Patient History");
        historyButton.setOnAction(e -> showHistory());

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> main.switchToLoginView());

        menu.getChildren().addAll(examineButton, prescribeButton, historyButton, logoutButton);
        rootLayout.setLeft(menu);

        Scene scene = new Scene(rootLayout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showExamine() {
        final Stage dialog = new Stage();
        dialog.setTitle("Examine");
        dialog.initModality(Modality.APPLICATION_MODAL);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        Label idLabel = new Label("Patient ID:");
        grid.add(idLabel, 0, 0);

        idField = new TextField();
        grid.add(idField, 1, 0);

        Button SearchPatient = new Button("Search");
        grid.add(SearchPatient,2,0);

        messageLabel = new Label();
        grid.add(messageLabel, 0, 3, 2, 1);

        SearchPatient.setOnAction(e -> Searchpatient());

        Scene dialogScene = new Scene(grid, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    private void showPrescribe() {
        Label prescribeLabel = new Label("This is the prescribe section. Here you can prescribe medication for a patient.");
        rootLayout.setCenter(prescribeLabel);
    }

    private void showHistory() {
        Label historyLabel = new Label("This is the history section. Here you can view a patient's visit history.");
        rootLayout.setCenter(historyLabel);
    }

    private void Searchpatient() {
        String id = idField.getText();
        if (PATIENT_ID.equals(id)) {
            messageLabel.setText("Patient Found");
        } else {
            messageLabel.setText("No Found Patient");
        }
    }
}
