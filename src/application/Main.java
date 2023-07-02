package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    // Views
    private LoginView loginView;
    private DoctorView doctorView;
    private PatientPortalView patientPortalView;
    private NurseView nurseView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Create the views
        loginView = new LoginView();
        doctorView = new DoctorView();
        patientPortalView = new PatientPortalView();
        nurseView = new NurseView();

        // Initially, show the login view
        primaryStage.setScene(loginView.getScene());
        primaryStage.show();
    }
<<<<<<< Updated upstream
=======
    
    public void switchToPatientPortalView() {
        // Create the patient portal view and switch the scene
        PatientPortalView patientPortalView = new PatientPortalView(null);
        Scene patientPortalScene = patientPortalView.getScene();
        this.stage.setScene(patientPortalScene);
    }
>>>>>>> Stashed changes
}




