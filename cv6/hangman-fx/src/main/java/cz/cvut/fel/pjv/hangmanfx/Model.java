package cz.cvut.fel.pjv.hangmanfx;

import java.util.Random;

public class Model {
  static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private final int MAX_MISS = 6;
  private String hiddenWord;
  private String guessedWord;
  private int missCount = 0;

  void selectHiddenWord(WordSource ws) {
    hiddenWord = ws.getWord();
  }

  void initGuessedWord() {
    guessedWord = ".".repeat(hiddenWord.length());
  }

  boolean updateGuessedWord(char guessedChar) {
    String newGuessedWord = "";
    boolean guessed = false;
    for (int i = 0 ; i < hiddenWord.length(); i++) {
      if (guessedChar == hiddenWord.charAt(i)) {
        newGuessedWord += guessedChar;
        guessed = true;
      }
      else {
        newGuessedWord += guessedWord.charAt(i);
      }
    }
    guessedWord = newGuessedWord;
    if (!guessed) {
      missCount++;
    }
    return guessed;
  }

  boolean isLost() {
    return missCount == MAX_MISS;
  }

  boolean isWin() {
    return guessedWord.equals(hiddenWord);
  }

  String getGuessedWord() {
    return guessedWord;
  }

  int getMissCount() {
    return missCount;
  }
}
