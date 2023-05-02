package cz.cvut.fel.pjv;

import java.io.*;
import java.net.Socket;

public class Client {
  public static void main(String[] args) {
    try (
        Socket clSocket = new Socket("localhost", 4455);
        BufferedReader br = new BufferedReader(new InputStreamReader(clSocket.getInputStream()));
        ObjectInputStream ois = new ObjectInputStream(clSocket.getInputStream());
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(clSocket.getOutputStream()),true);
    ) {
      String[] outgoing = {"One", "Two", "333", "getbinary", "exit"};
      for (String msg : outgoing) {
        System.out.println("SENDING :" + msg);
        pw.println(msg);
        if (msg.equals("getbinary")) {
          System.out.println(ois.readObject());
        } else {
          System.out.println("RECEIVED: " + br.readLine());
        }
      }
    } catch (IOException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }

  }
}
