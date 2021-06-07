package View;

import java.awt.BorderLayout;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ViewModel{
  public static void main(String args[]) {
    JFrame frame = new JFrame("Stadium-Simulation");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 100);

    JLabel tittle = new JLabel("Enter quntiti of:");
    JTextField tracks = new JTextField("Tracks..."), cloakrooms = new JTextField("Cloakrooms..."), sandpits = new JTextField("Sandpits...");
    JButton button = new JButton("OK");
    
    frame.getContentPane().add(BorderLayout.NORTH, tittle);
    frame.getContentPane().add(BorderLayout.EAST, tracks);
    frame.getContentPane().add(BorderLayout.WEST, cloakrooms);
    frame.getContentPane().add(BorderLayout.CENTER, sandpits);
    frame.getContentPane().add(BorderLayout.SOUTH, button);
    frame.setVisible(true);

    Action settingsButton = new SettingsButtonAction(frame, tracks, cloakrooms, sandpits);
    button.addActionListener(settingsButton);
  }
}
