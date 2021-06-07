package View;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SettingsButtonAction extends AbstractAction {
  JFrame frame;
  JTextField tracks, cloakrooms, sandpits;

  SettingsButtonAction(JFrame frame, JTextField tracks, JTextField cloakrooms, JTextField sandpits){
    this.frame = frame;
    this.tracks = tracks;
    this.cloakrooms = cloakrooms;
    this.sandpits = sandpits;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    JFrame second = new JFrame("Stadium-Simulation");
    second.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    second.setSize(800, 600);
    
    StadionView stadionView = new StadionView(Integer.parseInt(tracks.getText()), Integer.parseInt(cloakrooms.getText()), Integer.parseInt(sandpits.getText()));
    JLabel jLabel = new JLabel(stadionView);
    second.getContentPane().add(jLabel);
    AnimationView animationView = new AnimationView(second, stadionView.sectorViews.get(2).getPosition(), stadionView.sectorViews.get(4).getPosition());
    JLabel animation = new JLabel(animationView);
    // frame.getContentPane().add(animation);
    frame.add(animation, );
    second.setVisible(true);
  }
}
