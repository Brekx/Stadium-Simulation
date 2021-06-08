package Utilities;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Canva extends JPanel {
  List <SectorView> sectorViews;
  Dimension ludzik_position;
  Boolean animacja = false;
  int current_frame = 0;

  Canva(int tracks, int sandpits, int cloakrooms){
    generarateSectors(tracks, cloakrooms, sandpits);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    ImageIcon stadion = new ImageIcon("app/src/main/resources/stadion.png");
    g.drawImage(stadion.getImage(), 0, 0, null);
    for(SectorView sectorView : sectorViews){
      sectorView.drawSector(g);
    }
    if(animacja){
      ImageIcon ludzik = new ImageIcon(new ImageIcon("app/src/main/resources/ludzik.png").getImage().getScaledInstance(30, 70, Image.SCALE_SMOOTH));
      g.drawImage(ludzik.getImage(), ludzik_position.width, ludzik_position.height, null);
    }
  }

  public void moveBetween(int index_from, int index_to){
    move(sectorViews.get(index_from).getPosition(), sectorViews.get(index_to).getPosition());
  }

  public void move(Dimension start, Dimension end){
    int dx=(int) (end.getWidth()-start.getWidth())/100,
      dy=(int) (end.getHeight()-start.getHeight())/100;
    ludzik_position = new Dimension(start.width, start.height);
    animacja = true;
    new Timer(10, new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        ludzik_position.width += dx;
        ludzik_position.height += dy;
        current_frame++;
        if(current_frame>100){
          current_frame = 0;
          animacja = false;
          ((Timer)e.getSource()).stop();
        }
      }
    }).start();
  }

  private void generarateSectors(int tracks, int cloakrooms, int sandpits){
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
}
