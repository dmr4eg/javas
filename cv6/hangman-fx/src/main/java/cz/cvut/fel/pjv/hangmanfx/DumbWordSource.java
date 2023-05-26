package cz.cvut.fel.pjv.hangmanfx;

public class DumbWordSource implements WordSource {
  @Override
  public String getWord() {
    return "APPLE";
  }
}
