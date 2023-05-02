package cz.cvut.fel.pjv;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerSide implements Runnable{
  private final Socket socket;

  public ServerSide(Socket socket) {
    this.socket = socket;
    new Thread(this).start();
  }

  @Override
  public void run() {
    try (
      BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
      ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
    ) {
      List<String> messages = new ArrayList<>();
      String incoming;
      while (true) {
        incoming = br.readLine();
        if (incoming == null || incoming.equals("exit")) {
          break;
        } else if (incoming.equals("getbinary")) {
          oos.writeObject(messages);
        }
        System.out.println("RECEIVED :" + incoming);
        messages.add(incoming);
        pw.println("ECHO: " + incoming);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
