/*
 *  Created for B0B36PJV in b202
 */
package cz.cvut.fel.pjv;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.stage.Stage;

/**
 *
 * @author ladislav.seredi@fel.cvut.cz
 */
public class Main extends Application {
  Controller controller;
  
  @Override
  public void start(Stage primaryStage) {

    boolean master = !getParameters().getRaw().isEmpty(); // no command line params = slave

    Model model = new Model(master);

    View view = new View(model);

    model.addObserver(view); // <--- Observer pattern

    controller = new Controller(model);
    controller.start();
    
    primaryStage.setScene(view.getScene());

    // listen to window size change, propagate changes to model
    view.getScene().widthProperty().addListener(new InvalidationListener() {
      @Override
      public void invalidated(Observable observable) {
        model.setSceneWidth(view.getScene().getWidth());
      }
    });

    view.getScene().heightProperty().addListener(new InvalidationListener() {
      @Override
      public void invalidated(Observable observable) {
        model.setSceneHeight(view.getScene().getHeight());
      }
    });

    primaryStage.setTitle("Bounce - " + (master ? "master" : "slave"));
    primaryStage.show();
  }

  @Override
  public void stop() {
    controller.stop();
  }
  
  public static void main(String[] args) {
    launch(args);
  }
}
