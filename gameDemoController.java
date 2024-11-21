import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class gameDemoController {

    @FXML
    private TextField scoreTextField;

    @FXML
    private RadioButton easyButton;

    @FXML
    private RadioButton mediumButton;

    @FXML
    private RadioButton hardButton;

    @FXML
    private RadioButton volcanicButton;

    @FXML
    private Button newGameButton;

    // Declare the RandomGrid object and other necessary variables
    private RandomGrid randomGrid;
    private int width = 10; // Default width
    private int height = 10; // Default height
    private int jackpots = 3; // Example number of jackpots

    // Event handler for the 'New Game' button
    @FXML
    void newGame(ActionEvent event) {
        // Determine the difficulty selected by the user
        String difficulty = getSelectedDifficulty();

        // Adjust the difficulty of the RandomGrid
        randomGrid = new RandomGrid(width, height, 0.3, 0.3, 0.2, 0.1, 0.1, jackpots); // Example weight values
        randomGrid.adjustDifficulty(difficulty);  // Adjust weights based on difficulty

        // Initialize the grid with the adjusted difficulty settings
        randomGrid.initializeGrid();

        // Reset the score field
        scoreTextField.setText("0");

        // Provide feedback to the user
        showAlert("New Game", "A new game has started with " + difficulty + " difficulty.");
    }

    // Get the currently selected difficulty from the ToggleGroup
    private String getSelectedDifficulty() {
        if (easyButton.isSelected()) {
            return "easy";
        } else if (mediumButton.isSelected()) {
            return "medium";
        } else if (hardButton.isSelected()) {
            return "hard";
        } else if (volcanicButton.isSelected()) {
            return "volcanic";
        } else {
            return "medium"; // Default to medium if none selected
        }
    }

    // Utility method to show an alert
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
