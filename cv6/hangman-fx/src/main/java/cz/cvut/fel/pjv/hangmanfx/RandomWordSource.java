package cz.cvut.fel.pjv.hangmanfx;

import java.util.Random;

public class RandomWordSource implements WordSource{
  private static final String[] HIDDEN_WORDS = {
      "GHOST", "FLOWER", "BANANA", "SNOWFLAKE", "BOOK", "SNAKE", "LIGHT",
      "TREE", "LIPS", "APPLE", "SLIDE", "SOCKS", "SMILE", "SWING", "COAT",
      "SHOE", "WATER", "HEART", "OCEAN", "KITE", "MOUTH", "MILK", "DUCK",
      "EYES", "SKATEBOARD", "BIRD", "APPLE", "PERSON", "GIRL", "MOUSE",
      "BALL", "HOUSE", "STAR", "NOSE", "WHALE", "JACKET", "SHIRT", "HIPPO",
      "BEACH", "FACE", "COOKIE", "CHEESE", "DRUM", "CIRCLE", "SPOON", "WORM"
  };

  @Override
  public String getWord() {
    int idx = new Random().nextInt(0,HIDDEN_WORDS.length);
    return HIDDEN_WORDS[idx];
  }
}
