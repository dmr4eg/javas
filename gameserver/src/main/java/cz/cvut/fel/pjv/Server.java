/*
 *  Created for B0B36PJV in b202
 */
package cz.cvut.fel.pjv;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ladislav.seredi@fel.cvut.cz
 */
public class Server {
  private final int PORT_NUMBER;
  private static final Logger LOGGER = Logger.getLogger(Server.class.getName());
  private final List<Connection> connections;

  private ServerSocket serverSocket;
  private Socket socket;

  public Server(int PORT_NUMBER) {
    this.PORT_NUMBER = PORT_NUMBER;
    connections = new ArrayList<>();
  }

  public void start() {
    try {
      // start server...
      serverSocket = new ServerSocket(PORT_NUMBER);
      LOGGER.info("The server is running.");
      while (connections.size() < 2) {
        // listening for clients...
        socket = serverSocket.accept();
        LOGGER.info("The server is accepted connection.");
        // ...open new connection with client
        Connection connection = new Connection(this, socket);
        new Thread(connection).start();
      }
    } catch (IOException ex) {
      LOGGER.log(Level.SEVERE, "The server is not running. {0}", ex.getMessage());
    } finally {
      stop();
    }
  }

  public boolean addConnection(Connection newConnection, String newName) {
    // add only connection with name not yet existing
    synchronized(connections) {
      for (Connection connection : connections) {
        if (connection.getName().equals(newName)) {
          return false;
        }
      }
      LOGGER.info("Adding connection for " + newName);
      connections.add(newConnection);
      return true;
    }
  }

  public void removeConnection(String nameToRemove) {
    synchronized(connections) {
      for (Iterator<Connection> it = connections.iterator(); it.hasNext();) {
        Connection connection = it.next();
        if (connection.getName().equals(nameToRemove)) {
          LOGGER.info("Removing connection for " + nameToRemove);
          it.remove();
        }
      }
    }
  }

  public void sendToOthers(Protocol code, String payload, String senderName) {
    synchronized(connections) {
      for (Connection connection : connections) {
        if (!connection.getName().equals(senderName)) {
          connection.sendToClient(code, payload);
        }
      }
    }
  }

  public void stop() {
    LOGGER.info("Stopping server.");
    try {
      if (serverSocket != null && !serverSocket.isClosed()) {
        serverSocket.close();
      }
      if (socket != null) {
        socket.close();
      }
    } catch (IOException ex) {
      LOGGER.log(Level.SEVERE, "The server is failed to stop properly. {0}", ex.getMessage());
    }
  }
}
