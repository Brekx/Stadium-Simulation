package Utilities;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.ImageIcon; 
import javax.swing.Timer;

public class SectorView {
  private ImageIcon ludzik = new ImageIcon(new ImageIcon("app/src/main/resources/ludzik.png").getImage().getScaledInstance(30, 70, Image.SCALE_SMOOTH));
  private ImageIcon image;
  int current_people = 0, x, y, current_frame=0;
  SectorTypes type;
  boolean animation = false;
  Dimension ludzik_position = new Dimension();

  SectorView(SectorTypes type, int x, int y){
    this.x = x;
    this.y = y;
    this.type = type;
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
    for(int i=0; i<count; i++)
      g.drawImage(ludzik.getImage(), x+(i*dx/count), y+(i*dy/count), null);
  }

  public void drawSector(Graphics g) {
    g.drawImage(image.getImage(), (int) x-image.getIconWidth()/2, (int) y-image.getIconHeight()/2, null);
    drawPeople(g, x-100, y, 50, 0, current_people);
    if(animation){
      g.drawImage(ludzik.getImage(), ludzik_position.width, ludzik_position.height, null);
    }
  }

  public Dimension getPosition(){
    return new Dimension(x, y);
  }

  public void animate(){
    animation  = true;
    new Timer(10, new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        switch(type){
          case cloakroom:
            ludzik_position = cloakroom_path(current_frame);
            break;
          case sandpit:
            ludzik_position = sandpit_path(current_frame);
            break;
          case track:
            ludzik_position = track_path(current_frame);
            break;
        }
        current_frame++;
        if(current_frame>100){
          current_frame = 0;
          // animation = false;
          // ((Timer)e.getSource()).stop();
        }
      }
    }).start();
  }

  private Dimension cloakroom_path(int frame){
    if(frame<33)
      return new Dimension(x-65+3*frame, y-20-frame);
    if(frame<66)
      return new Dimension(x+35, y-50+(frame-33));
    return new Dimension(x+35-3*(frame-66), y-20-(frame-66));
  }

  private Dimension sandpit_path(int frame){
    if(frame<33)
      return new Dimension(x-81+2*frame, y-68+frame);
    if(frame<66)
      return new Dimension(x-15+(frame-33)/2, y-35-(frame-33)/2);
    return new Dimension(x+(frame-66)/2, y-50+(frame-66)/2);
  }

  private Dimension track_path(int frame){
    return new Dimension(x-100+frame, y-100+frame);
  }
}
