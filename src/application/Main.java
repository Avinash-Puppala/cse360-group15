package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage primaryStage;
    private LoginView loginView;
    private PatientPortalView patientPortalView;
    private DoctorView doctorView;
    private NurseView nurseView;
    private UserManager userManager;  // Added this line to declare userManager

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.userManager = new UserManager();  // Initialized userManager here
        this.loginView = new LoginView(this, userManager);  // Passing userManager instance to LoginView
        this.patientPortalView = new PatientPortalView(this);
        this.doctorView = new DoctorView(this);
        this.nurseView = new NurseView(this);

        switchToLoginView();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void switchToLoginView() {
        loginView.start(primaryStage);
    }

    public void switchToPatientPortalView() {
        patientPortalView.start(primaryStage);
    }

    public void switchToDoctorView() {
        doctorView.start(primaryStage);
    }

    public void switchToNurseView() {
        nurseView.start(primaryStage);
    }
}
