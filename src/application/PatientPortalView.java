package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class PatientPortalView {
    
    private Scene scene;
    
    private Main main;  // A reference to the Main instance.

    public PatientPortalView(Main main) {
    	
    	this.main = main;
    	
        TabPane tabPane = new TabPane();

        // Profile tab
        Tab profileTab = new Tab("Profile", createProfilePane());
        tabPane.getTabs().add(profileTab);

<<<<<<< HEAD
<<<<<<< Updated upstream
    public PatientPortalView() {
        VBox layout = new VBox();
        // TODO: add UI components to layout
=======
//        // Logout button
        Button logoutButton = new Button("Logout");
//        logoutButton.setOnAction(e -> main.switchToLoginView());
>>>>>>> Stashed changes
=======
        // Visit Summary tab
        Tab visitSummaryTab = new Tab("Visit Summary", createVisitSummaryPane());
        tabPane.getTabs().add(visitSummaryTab);
>>>>>>> dev

        // Messaging tab
        Tab messagingTab = new Tab("Messaging", createMessagingPane());
        tabPane.getTabs().add(messagingTab);

        // Logout button
        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> main.switchToLoginView());

        VBox layout = new VBox(tabPane, logoutButton);
        this.scene = new Scene(layout, 300, 250);
    }

    public Scene getScene() {
        return scene;
    }

    private GridPane createProfilePane() {
        // Create and populate the profile pane
        // This method should be updated to retrieve actual data for the patient
        GridPane gridPane = new GridPane();

        // Example:
        gridPane.add(new Label("First Name"), 0, 0);
        gridPane.add(new TextField("John"), 1, 0);
        gridPane.add(new Label("Last Name"), 0, 1);
        gridPane.add(new TextField("Doe"), 1, 1);

        // Add other profile fields and the Edit/Save/Cancel buttons

        return gridPane;
    }

    private TableView createVisitSummaryPane() {
        // Create and populate the visit summary table
        // This method should be updated to retrieve actual data for the patient
        TableView tableView = new TableView();

        // Example:
        TableColumn<String, String> visitDateColumn = new TableColumn<>("Visit Date");
        tableView.getColumns().add(visitDateColumn);
        TableColumn<String, String> doctorColumn = new TableColumn<>("Doctor");
        tableView.getColumns().add(doctorColumn);

        // Add other visit summary fields

        return tableView;
    }

    private VBox createMessagingPane() {
        // Create and populate the messaging pane
        VBox vBox = new VBox();

        Button newMessageButton = new Button("New Message");
        vBox.getChildren().add(newMessageButton);

        // Add message list or table

        return vBox;
    }
}

