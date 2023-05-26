package cz.cvut.fel.pjv.hangmanfx;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ModelTest {

  @Test
  void initGuessedWord() {
    Model sut = new Model();
    sut.selectHiddenWord(new DumbWordSource());
    sut.initGuessedWord();
    assertEquals(sut.getGuessedWord(), ".....");
  }

  @Test
  void updateGuessedWord() {
    Model sut = new Model();
    sut.selectHiddenWord(new DumbWordSource());
    sut.initGuessedWord();
    sut.updateGuessedWord('P');
    assertEquals(sut.getGuessedWord(), ".PP..");
  }

  @Test
  void isLostFalse() {
    Model sut = new Model();
    sut.selectHiddenWord(new DumbWordSource());
    sut.initGuessedWord();
    for (int i = 0; i < 5; i++) {
      sut.updateGuessedWord('Q');
    }
    assertEquals(sut.isLost(), false);
  }

  @Test
  void isLostTrue() {
    Model sut = new Model();
    sut.selectHiddenWord(new DumbWordSource());
    sut.initGuessedWord();
    for (int i = 0; i < 6; i++) {
      sut.updateGuessedWord('Q');
    }
    assertEquals(sut.isLost(), true);
  }

  @Test
  void isWinFalse() {
    Model sut = new Model();
    sut.selectHiddenWord(new DumbWordSource());
    sut.initGuessedWord();
    sut.updateGuessedWord('A');
    sut.updateGuessedWord('P');
    sut.updateGuessedWord('P');
    sut.updateGuessedWord('L');
    assertEquals(sut.isWin(), false);
  }

  @Test
  void isWinTrue() {
    Model sut = new Model();
    sut.selectHiddenWord(new DumbWordSource());
    sut.initGuessedWord();
    sut.updateGuessedWord('A');
    sut.updateGuessedWord('P');
    sut.updateGuessedWord('P');
    sut.updateGuessedWord('L');
    sut.updateGuessedWord('E');
    assertEquals(sut.isWin(), true);
  }
}