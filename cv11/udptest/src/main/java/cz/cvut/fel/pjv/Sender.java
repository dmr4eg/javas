package cz.cvut.fel.pjv;

import java.io.IOException;
import java.net.*;

public class Sender {
  public static void main(String[] args) {
    try (
      DatagramSocket ds = new DatagramSocket();
    ) {
      byte[] buffer = "Ahoj".getBytes();
      DatagramPacket dp = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 4455);
      ds.send(dp);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}