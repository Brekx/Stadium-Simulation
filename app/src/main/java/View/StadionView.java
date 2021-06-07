package View;

import java.awt.Component;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Utilities.SectorTypes;

public class StadionView implements Icon {
  List <SectorView> sectorViews;

  StadionView(int tracks, int cloakrooms, int sandpits){
    sectorViews = new ArrayList<SectorView>();
    int x, y, sum = tracks + cloakrooms + sandpits;
    for(int i=0; i<cloakrooms; i++){
      x = (int) (400+300*Math.sin(Math.toRadians(i*360/sum)));
      y = (int) (300+170*Math.cos(Math.toRadians(i*360/sum)));
      sectorViews.add(new SectorView(SectorTypes.cloakroom, x, y));
    }
    for(int i=0; i<sandpits; i++){
      x = (int) (400+300*Math.sin(Math.toRadians((i+cloakrooms)*360/sum)));
      y = (int) (300+170*Math.cos(Math.toRadians((i+cloakrooms)*360/sum)));
      sectorViews.add(new SectorView(SectorTypes.sandpit, x, y));
    }
    for(int i=0; i<tracks; i++){
      x = (int) (400+300*Math.sin(Math.toRadians((i+sandpits+cloakrooms)*360/sum)));
      y = (int) (300+170*Math.cos(Math.toRadians((i+sandpits+cloakrooms)*360/sum)));
      sectorViews.add(new SectorView(SectorTypes.track, x, y));
    }
  }

  public void draw_stadion(){
    JFrame frame = new JFrame("Stadium-Simulation");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);
    frame.getContentPane().add(frame, this);
    
    frame.setVisible(true);
  }

  @Override
  public void paintIcon(Component c, Graphics g, int x, int y) {
    ImageIcon stadion = new ImageIcon("stadion.png");
    g.drawImage(stadion.getImage(), 0, 0, null);
    for(SectorView sectorView : sectorViews){
      sectorView.drawSector(g);
    }
  }

  @Override
  public int getIconWidth() {
    return 800;
  }

  @Override
  public int getIconHeight() {
    return 600;
  }
}
