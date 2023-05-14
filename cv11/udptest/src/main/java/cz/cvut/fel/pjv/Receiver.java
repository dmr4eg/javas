package cz.cvut.fel.pjv;
import java.io.IOException;
import java.net.*;

public class Receiver {
  public static void main(String[] args) {
    try (
      DatagramSocket ds = new DatagramSocket(4455);
    ) {
      byte[] buffer = new byte[50];
      DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
      ds.receive(dp);
      System.out.println(new String(buffer).trim());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}