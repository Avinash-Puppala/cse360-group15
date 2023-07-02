package application;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class PatientPortalView {

    private Scene scene;

<<<<<<< Updated upstream
    public PatientPortalView() {
        VBox layout = new VBox();
        // TODO: add UI components to layout
=======
//        // Logout button
        Button logoutButton = new Button("Logout");
//        logoutButton.setOnAction(e -> main.switchToLoginView());
>>>>>>> Stashed changes

        scene = new Scene(layout, 300, 200);
    }

    public Scene getScene() {
        return scene;
    }
}
