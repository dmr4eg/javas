package cz.cvut.fel.pjv;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {
  private JButton klikniSemButton;
  private JPanel panel1;

  public MainForm() {
    klikniSemButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(klikniSemButton, "Ahoj!");
      }
    });
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("MainForm");
    frame.setContentPane(new MainForm().panel1);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
    System.out.println("Last command");
  }
}
