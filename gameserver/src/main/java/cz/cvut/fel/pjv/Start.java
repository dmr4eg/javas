package cz.cvut.fel.pjv;

public class Start {
  public static void main(String[] args) {
    Server server = new Server(4444);
    server.start();
  }
}
