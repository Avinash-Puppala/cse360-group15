package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.application.Platform;

public class DoctorView {

    private Main main;
    private Stage DoctorStage;
    private BorderPane rootLayout;
    private Scene scene;
    private TextField idField;
    private static final String PATIENT_ID = "12345";
    private Label messageLabel;
    private boolean result;

    public DoctorView(Main main) 
    {
        this.main = main;
    }

    public void start(Stage stage)
    {
        this.DoctorStage = stage;
        Doctor();
    }
    public void Doctor()
    {
        VBox layout = new VBox();
        rootLayout = new BorderPane();

        layout.setSpacing(10);

        Button examineButton = new Button("Examine Patient");
        examineButton.setOnAction(e -> showExamine());

        Button prescribeButton = new Button("Prescribe Medication");
        prescribeButton.setOnAction(e -> showPrescribe());

        Button historyButton = new Button("View Patient History");
        historyButton.setOnAction(e -> showHistory());

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> main.switchToLoginView());

        layout.getChildren().addAll(examineButton, prescribeButton, historyButton, logoutButton);
        rootLayout.setLeft(layout);

        scene = new Scene(rootLayout, 300, 200);
        DoctorStage.setTitle("Doctor View");
        DoctorStage.setScene(scene);
        DoctorStage.show();
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
        

        Label L_findings = new Label("Physical Examination Finding");
        Label L_diagnosis = new Label("Diagnosis");
        Label L_recommendations = new Label("Recommendations");

        TextField Findings = new TextField(); 
        TextField Diagnosis = new TextField();
        TextField Recommendations = new TextField();

        Button submit = new Button("Submit");

        grid.add(L_findings, 0, 4);

        L_findings.setVisible(false);
        L_diagnosis.setVisible(false);
        L_recommendations.setVisible(false);
        Findings.setVisible(false);
        Diagnosis.setVisible(false);
        Recommendations.setVisible(false);

        SearchPatient.setOnAction(event -> { 
            result = Searchpatient();
        });


        // if(result == true)
        // {
        //     Label L_findings = new Label("Physical Examination Finding");
        //     grid.add(L_findings, 0, 4);
        //     Findings = new TextField(); 
        //     Findings.setPrefSize(200, 1000);
        //     grid.add(Findings,0,5);
            

        //     Label L_diagnosis = new Label("Diagnosis");
        //     grid.add(L_diagnosis, 1, 4);
        //     Diagnosis = new TextField();
        //     Diagnosis.setPrefSize(200, 1000);
        //     grid.add(Diagnosis,1,5);
            
        //     Label L_recommendations = new Label("Recommendations");
        //     grid.add(L_recommendations, 2, 4);
        //     Recommendations = new TextField();
        //     Recommendations.setPrefSize(200, 1000);
        //     grid.add(Recommendations,2,5);

        //     Button submit = new Button("Submit");
        //     grid.add(submit, 1, 3);
        //     Scene dialogScene = new Scene(grid, 600, 800);
        //     dialog.setScene(dialogScene);
        //     dialog.show();
        // }
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

    private void showHistory()
    {
        final Stage dialog = new Stage();
        dialog.setTitle("Patient History");
        dialog.initModality(Modality.APPLICATION_MODAL);
        //dialog.initOwner(rootLayout);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        HBox hbox = new HBox();

        Label idLabel = new Label("Patient ID:");
        //grid.add(idLabel, 0, 0);


        idField = new TextField();
        //grid.add(idField, 1, 0);

        Button SearchPatient = new Button("Search");
        //grid.add(SearchPatient,2,0);

        hbox.getChildren().addAll(idLabel,idField,SearchPatient);
        grid.add(hbox,0,0);

        messageLabel = new Label();
        grid.add(messageLabel, 0, 1, 2, 1);

        SearchPatient.setOnAction(event -> { result = Searchpatient();});

        if(result)
        {
            TableView History = new TableView();
            TableColumn<String, String> dateColumn = new TableColumn<>("Visit Date");
            TableColumn<String, String> findingsColumn = new TableColumn<>("Examination Findings");
            TableColumn<String, String> diagnosisColumn = new TableColumn<>("Diagnosis");
            TableColumn<String, String> medicationColumn = new TableColumn<>("Prescribed Medication");
            History.getColumns().addAll(dateColumn, findingsColumn, diagnosisColumn, medicationColumn);
            History.setPrefSize(700, 400);

            grid.add(History,0,2);

        }
        Scene dialogScene = new Scene(grid, 800, 600);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    private void showPrescribe()
    {
        Stage PrescribeStage = new Stage();
        Scene PrescribeScene;
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        Label PatientID = new Label("Patient ID");
        Label MedicationName = new Label("Medication Name");
        Label Dosage = new Label("Dosage");
        Label Instruction = new Label("Instruction");

        TextField ID = new TextField();
        TextField MedicName = new TextField();
        TextField Dos = new TextField();
        TextField Inst = new TextField();

        Button Submit = new Button("submit");

        vbox.getChildren().addAll(PatientID,ID,MedicationName,MedicName,Dosage,Dos,Instruction,Inst,Submit);
        PrescribeScene = new Scene(vbox,400,300);
        PrescribeStage.setTitle("Prescribe");
        PrescribeStage.setScene(PrescribeScene);
        PrescribeStage.show();


    }



    public Scene getScene() {
        return this.scene;
    }
}

