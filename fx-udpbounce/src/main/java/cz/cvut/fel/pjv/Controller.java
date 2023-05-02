/*
 *  Created for B0B36PJV in b202
 */
package cz.cvut.fel.pjv;

import javafx.animation.AnimationTimer;

/**
 *
 * @author ladislav.seredi@fel.cvut.cz
 */
public class Controller extends AnimationTimer {
  private final Model model;
  private double lastUpdate = 0;

  public Controller(Model model) {
    this.model = model;
  }

  @Override
  public void handle(long now) {
    if (now - lastUpdate > 16_000_000) { // approx. 60 fps
      lastUpdate = now;
      model.updateBall();
    }
  }
}
