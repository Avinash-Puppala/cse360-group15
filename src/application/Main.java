package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private LoginView loginView;
    private PatientPortalView patientPortalView;

    private Stage stage;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;

        // Create the login view and set it as the initial scene
        LoginView loginView = new LoginView(this);
        Scene loginScene = loginView.getScene();
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }
    
    public void switchToPatientPortalView() {
        // Create the patient portal view and switch the scene
        PatientPortalView patientPortalView = new PatientPortalView();
        Scene patientPortalScene = patientPortalView.getScene();
        this.stage.setScene(patientPortalScene);
    }
}





