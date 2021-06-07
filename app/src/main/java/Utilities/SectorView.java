package Utilities;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Dimension;

import javax.swing.ImageIcon;

public class SectorView {
  private ImageIcon image;
   int current_people = 0, x, y;

  SectorView(SectorTypes type, int x, int y){
    this.x = x;
    this.y = y;
    switch(type){
      case track:
        image = new ImageIcon("app/src/main/resources/track.png");
        break;
      case cloakroom:
        image = new ImageIcon("app/src/main/resources/cloakroom.png");
        break;
      case sandpit:
        image = new ImageIcon("app/src/main/resources/sandpit.png");
        break;
    }
  }

  private void drawPeople(Graphics g, int x, int y, int dx, int dy, int count){
    ImageIcon imageIcon = new ImageIcon(new ImageIcon("ludzik.png").getImage().getScaledInstance(30, 70, Image.SCALE_SMOOTH));
    for(int i=0; i<count; i++)
      g.drawImage(imageIcon.getImage(), x+(i*dx/count), y+(i*dy/count), null);
  }

  public void drawSector(Graphics g) {
    g.drawImage(image.getImage(), (int) x-image.getIconWidth()/2, (int) y-image.getIconHeight()/2, null);
    drawPeople(g, x-100, y, 50, 0, current_people);
  }

  public Dimension getPosition(){
    return new Dimension(x, y);
  }
}
