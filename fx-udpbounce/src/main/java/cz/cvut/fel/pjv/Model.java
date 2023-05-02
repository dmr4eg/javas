/*
 *  Created for B0B36PJV in b202
 */
package cz.cvut.fel.pjv;

import java.beans.PropertyChangeSupport;

/**
 *
 * @author ladislav.seredi@fel.cvut.cz
 */
public class Model {

  private double sceneWidth = 500;
  private double sceneHeight = 400;
  private double centerX = 120;
  private double centerY = 100;
  private double speedX = 5;
  private double speedY = 8;
  private final double radius = 30;

  private final Udp udp;
  private final boolean master;

  private final PropertyChangeSupport propChangeSupport;

  public Model(boolean master) {
    this.propChangeSupport = new PropertyChangeSupport(this);
    udp = new Udp(master);
    this.master = master;
  }

    public void addObserver(View view) {
    propChangeSupport.addPropertyChangeListener(view);
  }

  public double getCenterX() {
    return centerX;
  }

  public double getCenterY() {
    return centerY;
  }

  public double getRadius() {
    return radius;
  }

  public double getSceneWidth() {
    return sceneWidth;
  }

  public double getSceneHeight() {
    return sceneHeight;
  }

  public void setSceneWidth(double stageWidth) {
    this.sceneWidth = stageWidth;
  }

  public void setSceneHeight(double stageHeight) {
    this.sceneHeight = stageHeight;
  }

  public void updateBall() {
    if (master) {
      calculateBallPosition();
    } else {
      listenUdpForBallPosition();
    }
  }

  public void listenUdpForBallPosition() {
    String msg = udp.receive();
    if (msg != null){
      String[] items = msg.split("\\|");
      setCenterX(Double.parseDouble(items[0]));
      setCenterY(Double.parseDouble(items[1]));
    }
  }

  public void calculateBallPosition() {
    double x = centerX + speedX;
    double y = centerY + speedY;
    if (x - radius < 0) {
      speedX = -speedX;
      x = radius;
    } else if (x + radius > sceneWidth) {
      speedX = -speedX;
      x = sceneWidth - radius;
    }
    if (y - radius < 0) {
      speedY = -speedY;
      y = radius;
    } else if (y + radius > sceneHeight) {
      speedY = -speedY;
      y = sceneHeight - radius;
    }
    setCenterX(x); // use setter to trigger prop change
    setCenterY(y); // dtto
    udp.broadcast(x + "|" + y);
  }

  private void setCenterX(double centerX) {
    propChangeSupport.firePropertyChange("centerX", this.centerX, centerX); // <--- Observer pattern
    this.centerX = centerX;
  }

  private void setCenterY(double centerY) {
    propChangeSupport.firePropertyChange("centerY", this.centerY, centerY); // <--- Observer pattern
    this.centerY = centerY;
  }
}
