package Utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

/// class representing utility view 
public class ViewUtility {
  private JFrame frame; ///< frame
  private Canva canva; ///< canva

  /**
   * Function that makes view
   * 
   * @param tracks tracks
   * @param sandpits sandpits
   * @param cloakrooms cloakrooms
   */
  public void makeView(int tracks, int sandpits, int cloakrooms){
    frame = new JFrame("Stadium-Simulation");
    canva = new Canva(tracks, sandpits, cloakrooms);
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

  /**
   * Frame getter
   * 
   * @return returns frame
   */
  public JFrame getFrame(){
    return frame;
  }

  /**
   * Canva getter
   * 
   * @return returns canva
   */
  public Canva getCanva(){
    return canva;
  }

  public static void main(String arg[]){
    ViewUtility viewUtility = new ViewUtility();
    viewUtility.makeView(1, 1, 1);
  }
}
