package cz.cvut.fel.pjv.hangmanfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {
    private ImageView hangmanImage = new ImageView();
    private int missCount = 0;
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

    @Override
    public void start(Stage stage) throws IOException {
        loadImage();
        Pane topPane = new BorderPane(hangmanImage);
        topPane.setPadding(new Insets(15));
        topPane.setStyle("-fx-background-color: 'green'");

        initGuessedWord();
        Label guessedWordLabel = new Label(guessedWord);
        guessedWordLabel.setStyle("-fx-font-size: 60");
        Pane middlePane = new BorderPane(guessedWordLabel);
        middlePane.setStyle("-fx-background-color: 'orange'");


        Pane bottomPane = new BorderPane();
        bottomPane.setStyle("-fx-background-color: 'blue'");
        for (char c : LETTERS.toCharArray()){
            Button button = new Button(String.valueOf(c));
            bottomPane.getChildren().add(button);

        }

        VBox root = new VBox(topPane, middlePane, bottomPane);
        Scene scene = new Scene(root, 320, 500); //ruzne sceny, na jednom screenu
        stage.setTitle("HangMan");
        stage.setScene(scene);
        stage.show();
    }

    private void loadImage() {
        hangmanImage.setImage(new Image("hangman_" + missCount + ".png"));
    }
    public static void main(String[] args) {
        launch();
    }

    private void selectHiddenWord() {
        int ind = new Random().nextInt(HIDDEN_WORDS.length);
        hiddenWord = HIDDEN_WORDS[ind];
    }

    private void updateGuessedWord(char c){
        StringBuilder sb = new StringBuilder(guessedWord);
        for (int i = 0; i < hiddenWord.length(); i++){
            if (hiddenWord.charAt(i) == c){
                sb.setCharAt(i, c);
            }
        }
        guessedWord = sb.toString();
    }
    private void initGuessedWord(){
        guessedWord = ".".repeat(hiddenWord.length());
    }
}