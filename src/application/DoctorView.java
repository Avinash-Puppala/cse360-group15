package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Platform;

public class DoctorView {

    private BorderPane rootLayout;
    private Scene scene;
    private TextField idField;
    private static final String PATIENT_ID = "12345";
    private Label messageLabel;
    private boolean result;
    private TextField Findings;
    private TextField Diagnosis;
    private TextField Recommendations;

    public DoctorView() 
    {
        VBox layout = new VBox();
        rootLayout = new BorderPane();

        layout.setSpacing(10);

        Button examineButton = new Button("Examine Patient");
        examineButton.setOnAction(e -> showExamine());

        Button prescribeButton = new Button("Prescribe Medication");
        //prescribeButton.setOnAction(e -> showPrescribe());

        Button historyButton = new Button("View Patient History");
        //historyButton.setOnAction(e -> showHistory());

        Button logoutButton = new Button("Logout");
        //logoutButton.setOnAction(e -> handleLogout());

        layout.getChildren().addAll(examineButton, prescribeButton, historyButton, logoutButton);
        rootLayout.setLeft(layout);

        scene = new Scene(rootLayout, 300, 200);
    }

    private void showExamine() 
    {
        final Stage dialog = new Stage();
        dialog.setTitle("Examine");
        dialog.initModality(Modality.APPLICATION_MODAL);
        //dialog.initOwner(rootLayout);

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

        SearchPatient.setOnAction(event -> { result = Searchpatient();});
        

        if(result == true)
        {
            Findings = new TextField("Physical Examination Findings");
            Findings.setPrefSize(200, 1000);
            grid.add(Findings,0,4);
            

            Diagnosis = new TextField("Diagnosis");
            Diagnosis.setPrefSize(200, 1000);
            grid.add(Diagnosis,1,4);

            Recommendations = new TextField("Recommendations");
            Recommendations.setPrefSize(200, 1000);
            grid.add(Recommendations,2,4);
        }
        Scene dialogScene = new Scene(grid, 600, 800);
        dialog.setScene(dialogScene);
        dialog.show();
    }
    
    private boolean Searchpatient()
    {
        String id = idField.getText();
        if (PATIENT_ID.equals(id)) 
        {
            messageLabel.setText("Patient Found");
            return true;
            
        }
        else
        {
            messageLabel.setText("No Found Patient");
            return false;
            
        }

    }

    public Scene getScene() {
        return scene;
    }
}

