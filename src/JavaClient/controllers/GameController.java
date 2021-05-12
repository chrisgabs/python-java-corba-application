package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    public Label menuButton;

    @FXML
    public Label rerollButton;

    @FXML
    public Label wordField;

    @FXML
    public TextField answerField;

    @FXML
    public Button submitButton;

    @FXML
    public Label warningField;

    @FXML
    public void submitAnswer() {
        boolean isCorrect = false;
        if (!answerField.getText().isEmpty()) {
            String user = User.username;
            String answer = answerField.getText();

            isCorrect = User.impl.checkAnswer(user, answer);
        }

        if (isCorrect) {
            requestWord();
            rerollWord();
            answerField.setText("");
        } else {
//            warningField.setVisible(true);
        }
    }

    @FXML
    public void accessMenu() {
        try {
            Stage window = (Stage) menuButton.getScene().getWindow();
            window.setScene(new Scene(FXMLLoader.load(getClass()
                    .getResource("../resources/view/Menu.fxml"))));
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void rerollWord() {
        String scrambledWord = User.impl.requestRescramble(User.username);
        wordField.setText(scrambledWord);
    }

    private void requestWord() {
        String user = User.username;

        String newWord = User.impl.requestWord(user);
        wordField.setText(newWord);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        requestWord();
        rerollWord();
    }
}