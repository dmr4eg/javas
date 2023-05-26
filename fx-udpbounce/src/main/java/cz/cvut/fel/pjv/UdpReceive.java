package cz.cvut.fel.pjv;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpReceive {

  public static void main(String[] args) throws IOException {
    DatagramSocket ds = new DatagramSocket(4456);
    byte[] receiveBuffer = new byte[50];
    DatagramPacket dp = new DatagramPacket(receiveBuffer, receiveBuffer.length);
    while (true) {
      ds.receive(dp);
      System.out.println(new String(receiveBuffer).trim());
    }
  }
}
