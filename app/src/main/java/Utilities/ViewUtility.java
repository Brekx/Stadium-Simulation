package Utilities;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewUtility {
  static JLabel jLabel;
  public static void main(String args[]){
    JFrame frame = new JFrame("Stadium-Simulation");
    Canva canva = new Canva(frame);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);
    frame.add(canva);
    frame.setVisible(true);
    canva.move(new Dimension(20, 100), new Dimension(700, 500));
  }
}
