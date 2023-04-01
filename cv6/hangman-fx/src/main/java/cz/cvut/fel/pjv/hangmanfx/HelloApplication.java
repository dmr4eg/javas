package cz.cvut.fel.pjv.hangmanfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
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
import java.util.Random;

public class HelloApplication extends Application {
  private final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private final String[] HIDDEN_WORDS = {
      "GHOST", "FLOWER", "BANANA", "SNOWFLAKE", "BOOK", "SNAKE", "LIGHT",
      "TREE", "LIPS", "APPLE", "SLIDE", "SOCKS", "SMILE", "SWING", "COAT",
      "SHOE", "WATER", "HEART", "OCEAN", "KITE", "MOUTH", "MILK", "DUCK",
      "EYES", "SKATEBOARD", "BIRD", "APPLE", "PERSON", "GIRL", "MOUSE",
      "BALL", "HOUSE", "STAR", "NOSE", "WHALE", "JACKET", "SHIRT", "HIPPO",
      "BEACH", "FACE", "COOKIE", "CHEESE", "DRUM", "CIRCLE", "SPOON", "WORM"
  };
  private final int MAX_MISS = 6;
  private String hiddenWord;
  private String guessedWord;
  private ImageView hagmanImage = new ImageView();

  private int missCount = 0;

  @Override
  public void start(Stage stage) throws IOException {
    selectHiddenWord();
    loadImage();
    Pane topPane = new BorderPane(hagmanImage);
    topPane.setPadding(new Insets(15));
//    topPane.setStyle("-fx-background-color: 'green'");

    initGuessedWord();
    Label guessedWordLabel = new Label(guessedWord);
    guessedWordLabel.setStyle("-fx-font-size: 60");
    Pane middlePane = new BorderPane(guessedWordLabel);
//    middlePane.setStyle("-fx-background-color: 'cyan'");

    Pane bottomPane = new FlowPane();
    bottomPane.setStyle("-fx-alignment: 'center'");
//    bottomPane.setStyle("-fx-background-color: 'orange'");
    for (Character c : LETTERS.toCharArray()) {
      Button button = new Button(c.toString());
      button.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
          updateGuessedWord(c);
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

  private void selectHiddenWord() {
    int idx = new Random().nextInt(0,HIDDEN_WORDS.length);
    hiddenWord = HIDDEN_WORDS[idx];
  }

  private void initGuessedWord() {
    guessedWord = ".".repeat(hiddenWord.length());
  }

  private void updateGuessedWord(char guessedChar) {
    String newGuessedWord = "";
    for (int i = 0 ; i < hiddenWord.length(); i++) {
      if (guessedChar == hiddenWord.charAt(i)) {
        //TODO!!!!
      }
    }
  }


  private void loadImage() {
    hagmanImage.setImage(new Image("hangman_" + missCount + ".png"));
  }

  public static void main(String[] args) {
    launch();
  }
}