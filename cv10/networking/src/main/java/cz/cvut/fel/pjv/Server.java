package cz.cvut.fel.pjv;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) {
    try (
      ServerSocket ss = new ServerSocket(4455);
    ) {
      System.out.println("Socket created");
      while (true) {
        Socket socket = ss.accept();
        System.out.println("Accepted");
        new ServerSide(socket);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}