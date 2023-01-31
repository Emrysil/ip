package controllers;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import sebastian.Sebastian;

/**
 * Class representing the main window of the GUI
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Sebastian sebastian;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/cat.jpg"));
    private Image sebastainImage = new Image(this.getClass().getResourceAsStream("/images/dog.jpg"));

    /**
     * Initialises the main window
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.setPadding(new Insets(30, 10, 0, 10));
        dialogContainer.setSpacing(30.0);
        scrollPane.setFitToWidth(true);

        BorderStroke borderStroke = new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID,
                new CornerRadii(20.0), new BorderWidths(1.0));
        Border roundBorder = new Border(borderStroke);
    }

    /**
     * Connects the application to the Sebastian instance
     * @param s the Sebastian instance
     */
    public void setSebastian(Sebastian s) {
        sebastian = s;
        dialogContainer.getChildren().add(
                DialogBox.getSebastianDialog(sebastian.getStartingMessage(), sebastainImage)
        );
    }


    /**
     * Handles user input
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = sebastian.getResponse(userInput.getText());
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getSebastianDialog(response, sebastainImage)
        );
        userInput.clear();
    }

}
