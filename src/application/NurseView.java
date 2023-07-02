package application;

import javafx.application.Application;
<<<<<<< Updated upstream
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NurseView extends Application {

	private Stage primaryStage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		primaryStage.setTitle("Sun Devil Pediatrics System");

		// Create labels and text fields for login screen
		Label usernameLabel = new Label("Username:");
		TextField usernameField = new TextField();
		Label passwordLabel = new Label("Password:");
		PasswordField passwordField = new PasswordField();
		Button loginButton = new Button("Login");

		// Set button action for login
		loginButton.setOnAction(event -> {
			showNursePortal();
		});

		// Create a layout for the login screen
		VBox loginLayout = new VBox(10);
		loginLayout.setPadding(new Insets(10));
		loginLayout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton);

		// Set the scene for the login screen
		Scene loginScene = new Scene(loginLayout, 300, 200);
		primaryStage.setScene(loginScene);
		primaryStage.show();
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
			showLoginScreen();
		});

		// Create a layout for the Nurse Portal screen
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(10));
		layout.getChildren().addAll(officeNameLabel, checkInButton, updateRecordsButton, viewPatientHistoryButton, viewMessagesButton,
				logoutButton);

		// Set the scene for the Nurse Portal screen
		Scene scene = new Scene(layout, 400, 300);
		primaryStage.setTitle("Nurse Portal");
		primaryStage.setScene(scene);
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

	private void showLoginScreen() {
		primaryStage.setTitle("Sun Devil Pediatrics System");

		// Create labels and text fields for login screen
		Label usernameLabel = new Label("Username:");
		TextField usernameField = new TextField();
		Label passwordLabel = new Label("Password:");
		PasswordField passwordField = new PasswordField();
		Button loginButton = new Button("Login");

		// Set button action for login
		loginButton.setOnAction(event -> {
			showNursePortal();
		});

		// Create a layout for the login screen
		VBox loginLayout = new VBox(10);
		loginLayout.setPadding(new Insets(10));
		loginLayout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton);

		// Set the scene for the login screen
		Scene loginScene = new Scene(loginLayout, 300, 200);
		primaryStage.setScene(loginScene);
	}
}
=======
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class NurseView extends Application {
    private Main app;
    private BorderPane rootLayout;

    public NurseView(Main app) {
        this.app = app;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Nurse View");

        rootLayout = new BorderPane();

        // Company Logo
        // Replace "logoImage" with the actual image node representing your company logo
        ImageView logoImage = new ImageView("path/to/company_logo.png");
        rootLayout.setTop(logoImage);

        // Office Name
        Label officeNameLabel = new Label("Sun Devil Pediatrics - Nurse Portal");
        rootLayout.setCenter(officeNameLabel);

        // Navigation/Dashboard Menu
        VBox menu = new VBox();
        menu.setSpacing(10);

        Button checkInButton = new Button("Check-In Patient");
        checkInButton.setOnAction(e -> showCheckIn());

        Button updateInfoButton = new Button("Update Patient Records");
        updateInfoButton.setOnAction(e -> showUpdateInfo());

        Button historyButton = new Button("View Patient History");
        historyButton.setOnAction(e -> showHistory());

        Button messagesButton = new Button("View Messages");
        messagesButton.setOnAction(e -> showMessages());

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> handleLogout());

        menu.getChildren().addAll(checkInButton, updateInfoButton, historyButton, messagesButton, logoutButton);
        rootLayout.setLeft(menu);

        Scene scene = new Scene(rootLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showCheckIn() {
        // Check-in Patient Section
        Label patientIdLabel = new Label("Patient ID:");
        TextField patientIdField = new TextField();
        Button searchButton = new Button("Search");

        Label weightLabel = new Label("Weight:");
        TextField weightField = new TextField();

        Label heightLabel = new Label("Height:");
        TextField heightField = new TextField();

        Label temperatureLabel = new Label("Body Temperature:");
        TextField temperatureField = new TextField();

        Label bloodPressureLabel = new Label("Blood Pressure:");
        TextField bloodPressureField = new TextField();

        Label allergiesLabel = new Label("Known Allergies:");
        TextField allergiesField = new TextField();

        Label healthConcernsLabel = new Label("Health Concerns:");
        TextField healthConcernsField = new TextField();

        Button submitButton = new Button("Submit");

        VBox checkInForm = new VBox(10, patientIdLabel, patientIdField, searchButton, weightLabel, weightField,
                heightLabel, heightField, temperatureLabel, temperatureField, bloodPressureLabel, bloodPressureField,
                allergiesLabel, allergiesField, healthConcernsLabel, healthConcernsField, submitButton);

        rootLayout.setCenter(checkInForm);
    }

    private void showUpdateInfo() {
        // Update Patient Record Section
        Label patientIdLabel = new Label("Patient ID:");
        TextField patientIdField = new TextField();
        Button searchButton = new Button("Search");

        Label firstNameLabel = new Label("First Name:");
        TextField firstNameField = new TextField();

        Label lastNameLabel = new Label("Last Name:");
        TextField lastNameField = new TextField();

        Label dobLabel = new Label("Date of Birth:");
        TextField dobField = new TextField();

        Label contactNumberLabel = new Label("Contact Number:");
        TextField contactNumberField = new TextField();

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();

        Label insuranceProviderLabel = new Label("Insurance Provider:");
        TextField insuranceProviderField = new TextField();

        Label insurancePolicyNumberLabel = new Label("Insurance Policy Number:");
        TextField insurancePolicyNumberField = new TextField();

        Label pharmacyDetailsLabel = new Label("Pharmacy Details:");
        TextField pharmacyDetailsField = new TextField();

        Button updateButton = new Button("Update");

        VBox updateInfoForm = new VBox(10, patientIdLabel, patientIdField, searchButton, firstNameLabel, firstNameField,
                lastNameLabel, lastNameField, dobLabel, dobField, contactNumberLabel, contactNumberField, emailLabel,
                emailField, insuranceProviderLabel, insuranceProviderField, insurancePolicyNumberLabel,
                insurancePolicyNumberField, pharmacyDetailsLabel, pharmacyDetailsField, updateButton);

        rootLayout.setCenter(updateInfoForm);
    }

    private void showHistory() {
        // View Patient History Section
        Label patientIdLabel = new Label("Patient ID:");
        TextField patientIdField = new TextField();
        Button searchButton = new Button("Search");

        TableView<VisitHistory> historyTable = new TableView<>();

        TableColumn<VisitHistory, String> visitDateColumn = new TableColumn<>("Visit Date");
        visitDateColumn.setCellValueFactory(new PropertyValueFactory<>("visitDate"));

        TableColumn<VisitHistory, String> examinationFindingsColumn = new TableColumn<>("Examination Findings");
        examinationFindingsColumn.setCellValueFactory(new PropertyValueFactory<>("examinationFindings"));

        TableColumn<VisitHistory, String> diagnosisColumn = new TableColumn<>("Diagnosis");
        diagnosisColumn.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));

        TableColumn<VisitHistory, String> medicationColumn = new TableColumn<>("Prescribed Medication");
        medicationColumn.setCellValueFactory(new PropertyValueFactory<>("medication"));

        historyTable.getColumns().addAll(visitDateColumn, examinationFindingsColumn, diagnosisColumn, medicationColumn);

        VBox historyView = new VBox(10, patientIdLabel, patientIdField, searchButton, historyTable);
        rootLayout.setCenter(historyView);
    }

    private void showMessages() {
        // Messaging Section
        Button newMessageButton = new Button("New Message");

        TableView<Message> messageTable = new TableView<>();

        TableColumn<Message, String> senderColumn = new TableColumn<>("Sender");
        senderColumn.setCellValueFactory(new PropertyValueFactory<>("sender"));

        TableColumn<Message, String> subjectColumn = new TableColumn<>("Subject");
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));

        TableColumn<Message, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        messageTable.getColumns().addAll(senderColumn, subjectColumn, dateColumn);

        VBox messagesView = new VBox(10, newMessageButton, messageTable);
        rootLayout.setCenter(messagesView);
    }

    private void handleLogout() {
        Stage stage = (Stage) app.getPrimaryStage();
        new LoginPage(app).start(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
>>>>>>> Stashed changes
