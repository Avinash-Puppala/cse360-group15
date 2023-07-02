package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NurseView {

    private Main main;
    private Stage nurseStage;
    private Scene scene;

    public NurseView(Main main) {
        this.main = main;
    }

    public void start(Stage stage) {
        this.nurseStage = stage;
        showNursePortal();
    }

    public Scene getScene() {
        return this.scene;
    }
    
	private void showNursePortal() {
		// Create labels and buttons for Nurse Portal
		Label officeNameLabel = new Label("Sun Devil Pediatrics - Nurse Portal");
		Button checkInButton = new Button("Check-In Patient");
		Button updateRecordsButton = new Button("Update Patient Records");
		Button viewPatientHistoryButton = new Button("View Patient History");
		Button viewMessagesButton = new Button("View Messages");
		Button logoutButton = new Button("Logout");

		// Set button actions for Nurse Portal
		checkInButton.setOnAction(event -> {
			showCheckInSection();
		});

		updateRecordsButton.setOnAction(event -> {
			showUpdateRecordsSection();
		});
		
		viewPatientHistoryButton.setOnAction(event -> {
			showViewPatientHistorySection();
		});

		viewMessagesButton.setOnAction(event -> {
			showMessagingSection();
		});

		logoutButton.setOnAction(event -> {
			main.switchToLoginView();
		});

		// Create a layout for the Nurse Portal screen
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(10));
		layout.getChildren().addAll(officeNameLabel, checkInButton, updateRecordsButton, viewPatientHistoryButton, viewMessagesButton,
				logoutButton);

		// Set the scene for the Nurse Portal screen
		Scene scene = new Scene(layout, 400, 300);
        this.scene = scene;
        nurseStage.setTitle("Nurse Portal");
        nurseStage.setScene(scene);
        nurseStage.show();
	}

	private void showCheckInSection() {
		Stage checkInStage = new Stage();
		checkInStage.setTitle("Check-In Patient");

		// Create input fields and labels
		Label patientIdLabel = new Label("Patient ID:");
		TextField patientIdTextField = new TextField();
		Button searchButton = new Button("Search");

		// Create form fields
		Label weightLabel = new Label("Weight:");
		TextField weightTextField = new TextField();
		Label heightLabel = new Label("Height:");
		TextField heightTextField = new TextField();
		Label temperatureLabel = new Label("Body Temperature:");
		TextField temperatureTextField = new TextField();
		Label bloodPressureLabel = new Label("Blood Pressure:");
		TextField bloodPressureTextField = new TextField();
		Label allergiesLabel = new Label("Known Allergies:");
		TextField allergiesTextField = new TextField();
		Label concernsLabel = new Label("Health Concerns:");
		TextField concernsTextField = new TextField();

		// Create submit button
		Button submitButton = new Button("Submit");
		submitButton.setOnAction(event -> {
			// Handle form submission and saving the information
			String patientId = patientIdTextField.getText();
			String weight = weightTextField.getText();
			String height = heightTextField.getText();
			String temperature = temperatureTextField.getText();
			String bloodPressure = bloodPressureTextField.getText();
			String allergies = allergiesTextField.getText();
			String concerns = concernsTextField.getText();

			// Perform necessary actions with the entered data
			System.out.println("Patient ID: " + patientId);
			System.out.println("Weight: " + weight);
			System.out.println("Height: " + height);
			System.out.println("Body Temperature: " + temperature);
			System.out.println("Blood Pressure: " + bloodPressure);
			System.out.println("Known Allergies: " + allergies);
			System.out.println("Health Concerns: " + concerns);

			// Close the check-in stage
			checkInStage.close();
		});

		// Create a layout for the check-in section
		VBox checkInLayout = new VBox(10);
		checkInLayout.setPadding(new Insets(10));
		checkInLayout.getChildren().addAll(patientIdLabel, patientIdTextField, searchButton, weightLabel,
				weightTextField, heightLabel, heightTextField, temperatureLabel, temperatureTextField,
				bloodPressureLabel, bloodPressureTextField, allergiesLabel, allergiesTextField, concernsLabel,
				concernsTextField, submitButton);

		// Set the scene for the check-in stage
		Scene checkInScene = new Scene(checkInLayout, 400, 600);
		checkInStage.setScene(checkInScene);
		checkInStage.show();
	}

	private void showUpdateRecordsSection() {
		Stage updateRecordsStage = new Stage();
		updateRecordsStage.setTitle("Update Patient Records");

		// Create form fields and labels
		Label firstNameLabel = new Label("First Name:");
		TextField firstNameTextField = new TextField();
		Label lastNameLabel = new Label("Last Name:");
		TextField lastNameTextField = new TextField();
		Label dobLabel = new Label("Date of Birth:");
		TextField dobTextField = new TextField();
		Label contactNumberLabel = new Label("Contact Number:");
		TextField contactNumberTextField = new TextField();
		Label emailLabel = new Label("Email:");
		TextField emailTextField = new TextField();
		Label insuranceProviderLabel = new Label("Insurance Provider:");
		TextField insuranceProviderTextField = new TextField();
		Label insurancePolicyNumberLabel = new Label("Insurance Policy Number:");
		TextField insurancePolicyNumberTextField = new TextField();
		Label pharmacyDetailsLabel = new Label("Pharmacy Details:");
		TextField pharmacyDetailsTextField = new TextField();

		// Create submit button
		Button updateButton = new Button("Update");
		updateButton.setOnAction(event -> {
			// Handle form submission and saving the updated information
			String firstName = firstNameTextField.getText();
			String lastName = lastNameTextField.getText();
			String dob = dobTextField.getText();
			String contactNumber = contactNumberTextField.getText();
			String email = emailTextField.getText();
			String insuranceProvider = insuranceProviderTextField.getText();
			String insurancePolicyNumber = insurancePolicyNumberTextField.getText();
			String pharmacyDetails = pharmacyDetailsTextField.getText();

			// Perform necessary actions with the updated data
			System.out.println("First Name: " + firstName);
			System.out.println("Last Name: " + lastName);
			System.out.println("Date of Birth: " + dob);
			System.out.println("Contact Number: " + contactNumber);
			System.out.println("Email: " + email);
			System.out.println("Insurance Provider: " + insuranceProvider);
			System.out.println("Insurance Policy Number: " + insurancePolicyNumber);
			System.out.println("Pharmacy Details: " + pharmacyDetails);

			// Close the update records stage
			updateRecordsStage.close();
		});

		// Create a layout for the update records section
		VBox updateRecordsLayout = new VBox(10);
		updateRecordsLayout.setPadding(new Insets(10));
		updateRecordsLayout.getChildren().addAll(firstNameLabel, firstNameTextField, lastNameLabel, lastNameTextField,
				dobLabel, dobTextField, contactNumberLabel, contactNumberTextField, emailLabel, emailTextField,
				insuranceProviderLabel, insuranceProviderTextField, insurancePolicyNumberLabel,
				insurancePolicyNumberTextField, pharmacyDetailsLabel, pharmacyDetailsTextField, updateButton);

		// Set the scene for the update records stage
		Scene updateRecordsScene = new Scene(updateRecordsLayout, 400, 600);
		updateRecordsStage.setScene(updateRecordsScene);
		updateRecordsStage.show();
	}
	
	private void showViewPatientHistorySection() {
        // Create labels and text fields for patient ID search
        Label searchLabel = new Label("Enter Patient ID:");
        TextField patientIdField = new TextField();
        Button searchButton = new Button("Search");

        // Create a table to display patient history
        TableView<String[]> historyTable = new TableView<>();
        TableColumn<String[], String> dateColumn = new TableColumn<>("Visit Date");
        TableColumn<String[], String> findingsColumn = new TableColumn<>("Examination Findings");
        TableColumn<String[], String> diagnosisColumn = new TableColumn<>("Diagnosis");
        TableColumn<String[], String> medicationColumn = new TableColumn<>("Prescribed Medication");

        dateColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[0]));
        findingsColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[1]));
        diagnosisColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[2]));
        medicationColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[3]));

        historyTable.getColumns().addAll(dateColumn, findingsColumn, diagnosisColumn, medicationColumn);

        // Create a layout for the View Patient History section
        VBox viewPatientHistoryLayout = new VBox(10);
        viewPatientHistoryLayout.setPadding(new Insets(10));
        viewPatientHistoryLayout.getChildren().addAll(searchLabel, patientIdField, searchButton, historyTable);

        // Set the scene for the View Patient History section
        Scene viewPatientHistoryScene = new Scene(viewPatientHistoryLayout, 600, 400);
        Stage viewPatientHistoryStage = new Stage();
        viewPatientHistoryStage.setTitle("View Patient History");
        viewPatientHistoryStage.setScene(viewPatientHistoryScene);
        viewPatientHistoryStage.show();
    }
	

	private void showMessagingSection() {
		Stage messagingStage = new Stage();
		messagingStage.setTitle("Messaging");

		// Create a "New Message" button
		Button newMessageButton = new Button("New Message");

		// Create a list/table of messages
		TableView<String> messageTable = new TableView<>();
		TableColumn<String, String> messageColumn = new TableColumn<>("Message");
		messageColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
		messageTable.getColumns().add(messageColumn);

		// Create a message box for replying to messages
		TextArea messageBox = new TextArea();
		messageBox.setPromptText("Reply to message...");

		// Create a reply button
		Button replyButton = new Button("Reply");
		replyButton.setOnAction(event -> {
			// Handle replying to a message
			String replyMessage = messageBox.getText();
			System.out.println("Reply: " + replyMessage);
			messageBox.clear();
		});

		// Create a "Return to Home Page" button
		Button returnButton = new Button("Return to Home Page");
		returnButton.setOnAction(event -> {
			messagingStage.close();
		});

		// Create a layout for the messaging section
		VBox messagingLayout = new VBox(10);
		messagingLayout.setPadding(new Insets(10));
		messagingLayout.getChildren().addAll(newMessageButton, messageTable, messageBox, replyButton, returnButton);

		// Set the scene for the messaging stage
		Scene messagingScene = new Scene(messagingLayout, 400, 400);
		messagingStage.setScene(messagingScene);
		messagingStage.show();
	}

}