package cz.cvut.fel.pjv;

import java.io.IOException;
import java.net.*;
import java.util.logging.Logger;

public class Udp {

  private static final int PORT = 4569;

  private static final Logger LOGGER = Logger.getLogger(Udp.class.getName());

  private DatagramSocket socket;
  private final boolean master;

  public Udp(boolean master) {
    this.master = master;
    try {
      if (master) {
        socket = new DatagramSocket();
      } else {
        socket = new DatagramSocket(PORT);
        socket.setSoTimeout(10); // [ms]
      }
    } catch (SocketException ex) {
      LOGGER.severe("ERROR: While creating UDP socket on " + (master ? "master" : "slave"));
      ex.printStackTrace();
    }
  }

  public void broadcast(String msg) {
    if (!master) {
      LOGGER.severe("ERROR: Only master can broadcast!");
      return;
    }
    try {
      InetAddress ip = InetAddress.getLocalHost();
      byte[] buff = msg.getBytes();
      DatagramPacket packetToSend = new DatagramPacket(buff, buff.length, ip, PORT);
      socket.send(packetToSend);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public String receive() {
    if (master) {
      LOGGER.severe("ERROR: Master can't receive!");
      return null;
    }
    try {
      byte[] buff = new byte[16];
      DatagramPacket packetToReceive = new DatagramPacket(buff, buff.length);
      socket.receive(packetToReceive);
      return new String(buff).trim();
    } catch (SocketTimeoutException ex) {
      LOGGER.info("Timeout on receive");
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return null;
  }
}
