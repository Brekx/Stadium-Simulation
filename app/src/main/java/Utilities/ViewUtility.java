package Utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class ViewUtility {
  private JFrame frame;
  private Canva canva;

  public void makeView(){
    frame = new JFrame("Stadium-Simulation");
    canva = new Canva(2, 2, 2);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);
    frame.add(canva);
    frame.setVisible(true);
    new Timer(10, new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.revalidate();
        frame.repaint();
      }
    }).start();
  }

  public JFrame getFrame(){
    return frame;
  }

  public Canva getCanva(){
    return canva;
  }

  public static void main(String arg[]){
    ViewUtility viewUtility = new ViewUtility();
    viewUtility.makeView();
  }
}
