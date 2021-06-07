package View;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Canvas implements Icon{
  int height = 600, width = 800;
  public int tracks, cloakrooms, sandpits, people_in_tracks, people_in_sandpits, people_in_cloakrooms;

  Canvas(int tracks, int cloakrooms, int sandpits, int people_in_tracks, int people_in_sandpits, int people_in_cloakrooms){
    this.tracks = tracks;
    this.cloakrooms = cloakrooms;
    this.sandpits = sandpits;
    this.people_in_tracks = people_in_tracks;
    this.people_in_sandpits = people_in_sandpits;
    this.people_in_cloakrooms = people_in_cloakrooms;
  }

  @Override
  public void paintIcon(Component c, Graphics g, int x, int y) {
    ImageIcon stadion = new ImageIcon(new ImageIcon("stadion.png").getImage().getScaledInstance(800, 600, Image.SCALE_AREA_AVERAGING));
    g.drawImage(stadion.getImage(), 0, 0, null);
    drawSectors(g);
  }

  @Override
  public int getIconWidth() {
    return width;
  }

  @Override
  public int getIconHeight() {
    return height;
  }

  void drawPeople(Graphics g, int x, int y, int dx, int dy, int count){
    ImageIcon imageIcon = new ImageIcon(new ImageIcon("ludzik.png").getImage().getScaledInstance(30, 70, Image.SCALE_SMOOTH));
    for(int i=0; i<count; i++)
      g.drawImage(imageIcon.getImage(), x+(i*dx/count), y+(i*dy/count), null);
  }

  void drawSectors(Graphics g){
    ImageIcon track = new ImageIcon("track.png"), sandpit = new ImageIcon("sandpit.png"), cloakroom = new ImageIcon("cloakroom.png");
    int sum = tracks + cloakrooms + sandpits, x, y;
    for(int i=0; i < tracks; i++){
      x = (int) (400+150*Math.sin(Math.toRadians(i*360/sum)));
      y = (int) (300+150*Math.cos(Math.toRadians(i*360/sum)));
      g.drawImage(track.getImage(), (int) x-track.getIconWidth()/2, (int) y-track.getIconHeight()/2, null);
      drawPeople(g, x-50, y, 100, 0, people_in_tracks);
    }
    for(int i=0; i < cloakrooms; i++){
      x = (int) (400+150*Math.sin(Math.toRadians((i+tracks)*360/sum)));
      y = (int) (300+150*Math.cos(Math.toRadians((i+tracks)*360/sum)));
      g.drawImage(cloakroom.getImage(), (int) x-cloakroom.getIconWidth()/2, (int) y-cloakroom.getIconHeight()/2, null);
      drawPeople(g, x-50, y, 100, 0, people_in_cloakrooms);
    }
    for(int i=0; i< sandpits; i++){
      x = (int) (400+150*Math.sin(Math.toRadians((i+tracks+cloakrooms)*360/sum)));
      y = (int) (300+150*Math.cos(Math.toRadians((i+tracks+cloakrooms)*360/sum)));
      g.drawImage(sandpit.getImage(), (int) x-sandpit.getIconWidth()/2, (int) y-sandpit.getIconHeight()/2, null);
      drawPeople(g, x-50, y, 100, 0, people_in_sandpits);
    }
  }
  
}
