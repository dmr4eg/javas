package cz.cvut.fel.pjv;

import java.io.IOException;
import java.net.*;

public class UdpSend {

  public static void main(String[] args) throws IOException{
    DatagramSocket ds = new DatagramSocket();
    byte[] sendBuffer = "Hello".getBytes();
    InetAddress ia = InetAddress.getLocalHost();
    DatagramPacket dp = new DatagramPacket(sendBuffer, sendBuffer.length, ia, 4456);
    while (true) {
      ds.send(dp);
    }
  }
}
