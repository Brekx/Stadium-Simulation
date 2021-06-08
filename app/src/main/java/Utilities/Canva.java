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
  boolean animacja = false;
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
    if(index_from != index_to)
      move(sectorViews.get(index_from).getPosition(), sectorViews.get(index_to).getPosition());
  }

  public void move(Dimension start, Dimension end){
    ludzik_position = new Dimension(start.width, start.height);
    animacja = true;
    Timer timer = new Timer(10, new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        ludzik_position = move_path(current_frame, start, end);
        current_frame++;
        if(current_frame > 100){
          current_frame = 0;
          animacja = false;
          ((Timer)e.getSource()).stop();
        }
      }
    });
    timer.start();
    while(timer.isRunning())
      continue;
  }

  private static Dimension move_path(int frame, Dimension start, Dimension end){
      return new Dimension((int) (start.getWidth()+frame*(end.getWidth()-start.getWidth())/100), (int) (start.getHeight()+frame*(end.getHeight()-start.getHeight())/100));
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
