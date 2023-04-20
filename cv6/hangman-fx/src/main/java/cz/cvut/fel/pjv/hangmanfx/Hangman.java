package cz.cvut.fel.pjv.hangmanfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Hangman extends Application {
  private final ImageView hagmanImage = new ImageView();
  private final Model model = new Model();

  @Override
  public void start(Stage stage) throws IOException {
    model.selectHiddenWord();
    loadImage();
    Pane topPane = new BorderPane(hagmanImage);
    topPane.setPadding(new Insets(15));
//    topPane.setStyle("-fx-background-color: 'green'");

    model.initGuessedWord();
    Label guessedWordLabel = new Label(model.getGuessedWord());
    guessedWordLabel.setStyle("-fx-font-size: 60");
    Pane middlePane = new BorderPane(guessedWordLabel);
//    middlePane.setStyle("-fx-background-color: 'cyan'");

    Pane bottomPane = new FlowPane();
    bottomPane.setStyle("-fx-alignment: 'center'");
//    bottomPane.setStyle("-fx-background-color: 'orange'");
    for (Character c : Model.LETTERS.toCharArray()) {
      Button button = new Button(c.toString());
      button.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
          button.setDisable(true);
          if (!model.updateGuessedWord(c)) {
            loadImage();
            if (model.isLost()) {
              Alert loseAlert = new Alert(Alert.AlertType.WARNING);
              loseAlert.setHeaderText(null);
              loseAlert.setContentText("You've lost!");
              loseAlert.showAndWait();
            }
          } else {
            guessedWordLabel.setText(model.getGuessedWord());
            if (model.isWin()) {
              Alert winAlert = new Alert(Alert.AlertType.INFORMATION);
              winAlert.setHeaderText(null);
              winAlert.setContentText("You've win!");
              winAlert.showAndWait();
            }
          }
        }
      });
      bottomPane.getChildren().add(button);
    }

    VBox root = new VBox(topPane, middlePane, bottomPane);
    Scene scene = new Scene(root, 320, 500);
    stage.setTitle("Hangman");
    stage.setScene(scene);
    stage.show();
  }


  private void loadImage() {
    hagmanImage.setImage(new Image("hangman_" + model.getMissCount() + ".png"));
  }

  public static void main(String[] args) {
    launch();
  }
}