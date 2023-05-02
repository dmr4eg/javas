/*
 *  Created for B0B36PJV in b202
 */
package cz.cvut.fel.pjv;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author ladislav.seredi@fel.cvut.cz
 */
public class View implements PropertyChangeListener { // <--- Observer pattern
  private final Scene scene;
  private final Model model;
  private final ImageView imageView;

  public View(Model model) {
    this.model = model;
    imageView = new ImageView("ball.png");
    Pane root = new Pane(imageView);
    scene = new Scene(root, model.getSceneWidth(), model.getSceneHeight());
  }

  public Scene getScene() {
    return scene;
  }
  
  @Override
  public void propertyChange(PropertyChangeEvent evt) { // <--- Observer pattern
    imageView.setX(model.getCenterX() - model.getRadius());
    imageView.setY(model.getCenterY() - model.getRadius());
  }
}
