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

/**Class representing canva */
public class Canva extends JPanel {
  List <SectorView> sectorViews;
  Dimension ludzik_position;
  boolean animacja = false;
  int current_frame = 0;

  /**
   * Constructor
   * 
   * @param tracks number of tracks
   * @param sandpits number of sandpits
   * @param cloakrooms number of cloakroom
   */
  Canva(int tracks, int sandpits, int cloakrooms){
    generarateSectors(tracks, cloakrooms, sandpits);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    ImageIcon stadion = new ImageIcon(new ImageIcon("app/src/main/resources/stadion.png").getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH));
    g.drawImage(stadion.getImage(), 0, 0, null);
    for(SectorView sectorView : sectorViews){
      sectorView.drawSector(g);
    }
    if(animacja){
      ImageIcon ludzik = new ImageIcon(new ImageIcon("app/src/main/resources/ludzik.png").getImage().getScaledInstance(30, 70, Image.SCALE_SMOOTH));
      g.drawImage(ludzik.getImage(), ludzik_position.width, ludzik_position.height, null);
    }
  }

  /** 
   * Move from A to B
   * 
   * @param index_from index A
   * @param index_to index B
   */
  public void moveBetween(int index_from, int index_to){
    if(index_from != index_to)
      move(sectorViews.get(index_from).getPosition(), sectorViews.get(index_to).getPosition());
  }

  /** 
   * Moving from start to end dimension
   * 
   * @param start start
   * @param end end
   */
  public void move(Dimension start, Dimension end){
    ludzik_position = new Dimension(start.width, start.height);
    animacja = true;
    Timer timer = new Timer(10, new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        ludzik_position = move_path(current_frame, start, end);
        current_frame++;
        if(current_frame > 1){
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

  /** 
   * Determins path which icon follows
   * 
   * @param frame frame
   * @param start start
   * @param end end
   * 
   * @return returns new dimension
   */
  private static Dimension move_path(int frame, Dimension start, Dimension end){
      return new Dimension((int) (start.getWidth()+frame*(end.getWidth()-start.getWidth())/100), (int) (start.getHeight()+frame*(end.getHeight()-start.getHeight())/100));
  }

  /** 
   * Generate sectors view
   * 
   * @param tracks tracks
   * @param cloakrooms cloakrooms
   * @param sandpits sandpits
   */
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
